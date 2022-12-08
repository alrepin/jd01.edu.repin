package ga.repin.education.course03.topic04.hw.v3school.service;

import ga.repin.education.course03.topic04.hw.v3school.model.FacultyV3;
import ga.repin.education.course03.topic04.hw.v3school.model.StudentV3;
import ga.repin.education.course03.topic04.hw.v3school.repository.StudentRepositoryV3;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceV3 {

    private final StudentRepositoryV3 studentRepository;
    
    public StudentServiceV3(StudentRepositoryV3 studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public StudentV3 create(StudentV3 student) {
        
        Example<StudentV3> e = Example.of(student);
        boolean exists = studentRepository.exists(e);
        
        //if (!studentRepository.existsByName(student.getName())) {
        if (!exists) {
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV3 read(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV3> filter(Integer age, Integer min, Integer max) {
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
        return studentRepository.findByAgeBetween(min,max);
    }
    
    public StudentV3 update(long id, StudentV3 student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV3 delete(Long id) {
        Optional<StudentV3> s = studentRepository.findById(id);
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
    
    public FacultyV3 facultyOfStudentBy(Long studentId){
        return studentRepository.findById(studentId)
                .map(StudentV3::getFaculty).orElse(null);
    }
}
