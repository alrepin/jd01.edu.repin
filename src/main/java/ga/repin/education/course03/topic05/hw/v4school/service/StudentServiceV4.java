package ga.repin.education.course03.topic05.hw.v4school.service;

import ga.repin.education.course03.topic05.hw.v4school.model.FacultyV4;
import ga.repin.education.course03.topic05.hw.v4school.model.StudentV4;
import ga.repin.education.course03.topic05.hw.v4school.repository.StudentRepositoryV4;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceV4 {

    private final StudentRepositoryV4 studentRepository;
    
    public StudentServiceV4(StudentRepositoryV4 studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public StudentV4 create(StudentV4 student) {
        
        Example<StudentV4> e = Example.of(student);
        boolean exists = studentRepository.exists(e);
        
        //if (!studentRepository.existsByName(student.getName())) {
        if (!exists) {
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV4 read(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV4> filter(Integer age, Integer min, Integer max) {
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
    
    public StudentV4 update(long id, StudentV4 student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV4 delete(Long id) {
        Optional<StudentV4> s = studentRepository.findById(id);
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
    
    public FacultyV4 facultyOfStudentBy(Long studentId){
        return studentRepository.findById(studentId)
                .map(StudentV4::getFaculty).orElse(null);
    }
}
