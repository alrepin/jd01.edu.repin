package ga.repin.education.course04.topic04.hw.v7school.service;

import ga.repin.education.course04.topic04.hw.v7school.entity.FacultyV7;
import ga.repin.education.course04.topic04.hw.v7school.entity.StudentV7;
import ga.repin.education.course04.topic04.hw.v7school.repository.StudentRepositoryV7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceV7 {

    private final StudentRepositoryV7 studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentServiceV7.class);
    
    public StudentServiceV7(StudentRepositoryV7 studentRepository) {
        logger.debug("Service wire with Repository");
        this.studentRepository = studentRepository;
    }
    
    
    public StudentV7 create(StudentV7 student) {
        logger.info("Method create was invoked");
        Example<StudentV7> e = Example.of(student);
        boolean exists = studentRepository.exists(e);
        
        //if (!studentRepository.existsByName(student.getName())) {
        if (!exists) {
            logger.debug("Not double - create");
            return studentRepository.save(student);
        }
        logger.error("Not created cause double");
        return null;
    }
    
    public StudentV7 read(Long id) {
        logger.info("Method read was invoked");
        return studentRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV7> filter(Integer age, Integer min, Integer max) {
        logger.info("Method filter was invoked");
        if (age != null) {
            min = age;
            max = age;
        } else {
            if (min==null){
                min = 1;
            }
            if (max == null) {
                max = 120;
                
            }
        }
        logger.debug("Looking for records with age between " + min + " and " + max);
        return studentRepository.findByAgeBetween(min,max);
    }
    
    public StudentV7 update(long id, StudentV7 student) {
        logger.info("Method update was invoked");
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        logger.error("Nothing to update by ID: " + id);
        return null;
    }
    
    public StudentV7 delete(Long id) {
        logger.info("Method delete was invoked");
        Optional<StudentV7> s = studentRepository.findById(id);
        if (s.isPresent()) {
            try {
                studentRepository.deleteAll(s.stream().collect(Collectors.toList()));
            } catch (Exception e) {
                s = Optional.empty();
            } finally {
                return s.get();
            }
        }
        return null;
    }
    
    public FacultyV7 facultyOfStudentBy(Long studentId){
        logger.info("Method facultyOfStudentBy was invoked");
        return studentRepository.findById(studentId)
                .map(StudentV7::getFaculty).orElse(null);
    }
    
    public Integer calculateTotal(){
        logger.info("Method calculateTotal was invoked");
        return studentRepository.queryCalculateTotal();
    }
    
    public Double calculateAvgAge() {
        logger.info("Method calculateAvgAge was invoked");
        return studentRepository.queryCalculateAvgAge();
    }
    
    public List<StudentV7> listTail(Integer n){
        logger.info("Method listTail was invoked");
        return studentRepository.queryListTail(calculateTotal()>n ? calculateTotal() - n : 0);
    }
}
