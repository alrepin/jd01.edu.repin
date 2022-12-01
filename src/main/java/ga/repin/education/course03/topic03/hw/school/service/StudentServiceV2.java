package ga.repin.education.course03.topic03.hw.school.service;

import ga.repin.education.course03.topic03.hw.school.model.StudentV2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceV2 {
    private final Map<Long, StudentV2> students = new HashMap<>();
    private Long idCounter = 0L;
    
    
    public StudentV2 create(StudentV2 studentV2) {
        if (!students.containsValue(studentV2)) {
            studentV2.setId(++idCounter);
            students.put(studentV2.getId(), studentV2);
            return studentV2;
        }
        return null;
    }
    
    public StudentV2 read(Long id) {
        return students.get(id);
    }
    
    public Collection<StudentV2> filter(Integer age) {
        if (age == null) {
            return students.values();
        }
        return students.values().stream().filter(s -> s.getAge() == age).collect(Collectors.toSet());
    }
    
    public StudentV2 update(long id, StudentV2 studentV2) {
        if (students.containsKey(id)) {
            studentV2.setId(id);
            students.put(id, studentV2);
            return studentV2;
        }
        return null;
    }
    
    public StudentV2 delete(Long id) {
            return students.remove(id);
    }
}
