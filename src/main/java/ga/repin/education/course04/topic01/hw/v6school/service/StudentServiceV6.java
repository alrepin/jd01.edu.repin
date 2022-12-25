package ga.repin.education.course04.topic01.hw.v6school.service;

import ga.repin.education.course04.topic01.hw.v6school.entity.FacultyV6;
import ga.repin.education.course04.topic01.hw.v6school.entity.StudentV6;
import ga.repin.education.course04.topic01.hw.v6school.repository.StudentRepositoryV6;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceV6 {

    private final StudentRepositoryV6 studentRepository;
    
    public StudentServiceV6(StudentRepositoryV6 studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public StudentV6 create(StudentV6 student) {
        
        Example<StudentV6> e = Example.of(student);
        boolean exists = studentRepository.exists(e);
        
        //if (!studentRepository.existsByName(student.getName())) {
        if (!exists) {
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV6 read(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV6> filter(Integer age, Integer min, Integer max) {
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
    
    public StudentV6 update(long id, StudentV6 student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV6 delete(Long id) {
        Optional<StudentV6> s = studentRepository.findById(id);
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
    
    public FacultyV6 facultyOfStudentBy(Long studentId){
        return studentRepository.findById(studentId)
                .map(StudentV6::getFaculty).orElse(null);
    }
    
    public Integer calculateTotal(){
        return studentRepository.queryCalculateTotal();
    }
    
    public Double calculateAvgAge() {
        return studentRepository.queryCalculateAvgAge();
    }
    
    public List<StudentV6> listTail(Integer n){
        return studentRepository.queryListTail(calculateTotal()>n ? calculateTotal() - n : 0);
    }
}
