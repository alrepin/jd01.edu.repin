package ga.repin.education.course03.topic02.hw.school.service;

import ga.repin.education.course03.topic02.hw.school.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long idCounter = 0L;
    
    public Collection<Faculty> getFaculties(String color) {
        if (color == null) {
            return faculties.values();
        }
        return faculties.values().stream().filter(f -> f.getColor().equals(color)).collect(Collectors.toSet());
    }
    
    public Faculty create(Faculty faculty) {
        if (!faculties.containsValue(faculty)) {
            faculty.setId(++idCounter);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }
    
    public Faculty get(Long id) {
        return faculties.get(id);
    }
    
    public Faculty update(long id, Faculty faculty) {
        if (faculties.containsKey(id)) {
            faculty.setId(id);
            faculties.put(id, faculty);
            return faculty;
        }
        return null;
    }
    
    public Faculty delete(Long id) {
        return faculties.remove(id);
    }
}
