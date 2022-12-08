package ga.repin.education.course03.topic05.hw.v4school.service;

import ga.repin.education.course03.topic05.hw.v4school.model.Faculty;
import ga.repin.education.course03.topic05.hw.v4school.model.Student;
import ga.repin.education.course03.topic05.hw.v4school.repository.StudentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public Student create(Student student) {
        
        Example<Student> e = Example.of(student);
        boolean exists = studentRepository.exists(e);
        
        //if (!studentRepository.existsByName(student.getName())) {
        if (!exists) {
            return studentRepository.save(student);
        }
        return null;
    }
    
    public Student read(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Collection<Student> filter(Integer age, Integer min, Integer max) {
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
    
    public Student update(long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
    
    public Student delete(Long id) {
        Optional<Student> s = studentRepository.findById(id);
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
    
    public Faculty facultyOfStudentBy(Long studentId){
        return studentRepository.findById(studentId)
                .map(Student::getFaculty).orElse(null);
    }
}
