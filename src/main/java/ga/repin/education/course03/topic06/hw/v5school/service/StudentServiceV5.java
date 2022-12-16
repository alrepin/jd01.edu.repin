package ga.repin.education.course03.topic06.hw.v5school.service;

import ga.repin.education.course03.topic06.hw.v5school.model.FacultyV5;
import ga.repin.education.course03.topic06.hw.v5school.model.StudentV5;
import ga.repin.education.course03.topic06.hw.v5school.repository.StudentRepositoryV5;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceV5 {

    private final StudentRepositoryV5 studentRepository;
    
    public StudentServiceV5(StudentRepositoryV5 studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public StudentV5 create(StudentV5 student) {
        
        Example<StudentV5> e = Example.of(student);
        boolean exists = studentRepository.exists(e);
        
        //if (!studentRepository.existsByName(student.getName())) {
        if (!exists) {
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV5 read(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV5> filter(Integer age, Integer min, Integer max) {
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
    
    public StudentV5 update(long id, StudentV5 student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
    
    public StudentV5 delete(Long id) {
        Optional<StudentV5> s = studentRepository.findById(id);
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
    
    public FacultyV5 facultyOfStudentBy(Long studentId){
        return studentRepository.findById(studentId)
                .map(StudentV5::getFaculty).orElse(null);
    }
}
