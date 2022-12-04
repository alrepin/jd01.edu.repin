package ga.repin.education.course03.topic02.hw.v1school.service;

import ga.repin.education.course03.topic02.hw.v1school.model.StudentV1;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceV1 {
    private final Map<Long, StudentV1> students = new HashMap<>();
    private Long idCounter = 0L;
    
    
    public StudentV1 create(StudentV1 student) {
        if (!students.containsValue(student)) {
            student.setId(++idCounter);
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }
    
    public StudentV1 read(Long id) {
        return students.get(id);
    }
    
    public Collection<StudentV1> filter(Integer age) {
        if (age == null) {
            return students.values();
        }
        return students.values().stream().filter(s -> s.getAge() == age).collect(Collectors.toSet());
    }
    
    public StudentV1 update(long id, StudentV1 student) {
        if (students.containsKey(id)) {
            student.setId(id);
            students.put(id, student);
            return student;
        }
        return null;
    }
    
    public StudentV1 delete(Long id) {
            return students.remove(id);
    }
}
