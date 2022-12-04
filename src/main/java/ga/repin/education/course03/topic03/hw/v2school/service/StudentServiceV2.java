package ga.repin.education.course03.topic03.hw.v2school.service;

import ga.repin.education.course03.topic03.hw.v2school.model.StudentV2;
import ga.repin.education.course03.topic03.hw.v2school.repository.StudentRepositoryV2;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceV2 {

    private final StudentRepositoryV2 studentRepositoryV2;
    
    public StudentServiceV2(StudentRepositoryV2 studentRepositoryV2) {
        this.studentRepositoryV2 = studentRepositoryV2;
    }
    
    
    public StudentV2 create(StudentV2 student) {
        
        Example<StudentV2> e = Example.of(student);
        boolean exists = studentRepositoryV2.exists(e);
        
        //if (!studentRepositoryV2.existsByName(student.getName())) {
        if (!exists) {
            return studentRepositoryV2.save(student);
        }
        return null;
    }
    
    public StudentV2 read(Long id) {
        return studentRepositoryV2.findById(id).orElse(null);
    }
    
    public Collection<StudentV2> filter(Integer age) {
        if (age == null) {
            return studentRepositoryV2.findAll();
        }
        return studentRepositoryV2.findByAge(age);
    }
    
    public StudentV2 update(long id, StudentV2 student) {
        if (studentRepositoryV2.existsById(id)) {
            student.setId(id);
            return studentRepositoryV2.save(student);
        }
        return null;
    }
    
    public StudentV2 delete(Long id) {
        Optional<StudentV2> s = studentRepositoryV2.findById(id);
        if (s.isPresent()) {
            try {
                studentRepositoryV2.deleteAll(s.stream().collect(Collectors.toList()));
            } catch (Exception e) {
                s = Optional.empty();
            } finally {
                return s.get();
            }
        }
        return null;
    }
}
