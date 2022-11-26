package ga.repin.education.course03.topic02.hw.school.service;

import ga.repin.education.course03.topic02.hw.school.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long idCounter = 0L;
    
    
    public Student create(Student student) {
        if (!students.containsValue(student)) {
            student.setId(++idCounter);
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }
    
    public Student read(Long id) {
        return students.get(id);
    }
    
    public Collection<Student> filter(Integer age) {
        if (age == null) {
            return students.values();
        }
        return students.values().stream().filter(s -> s.getAge() == age).collect(Collectors.toSet());
    }
    
    public Student update(long id, Student student) {
        if (students.containsKey(id)) {
            student.setId(id);
            students.put(id, student);
            return student;
        }
        return null;
    }
    
    public Student delete(Long id) {
            return students.remove(id);
    }
}
