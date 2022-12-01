package ga.repin.education.course03.topic02.hw.school.service;

import ga.repin.education.course03.topic02.hw.school.model.FacultyV1;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV1 {
    private final Map<Long, FacultyV1> faculties = new HashMap<>();
    private Long idCounter = 0L;
    
    public Collection<FacultyV1> getFaculties(String color) {
        if (color == null) {
            return faculties.values();
        }
        return faculties.values().stream().filter(f -> f.getColor().equals(color)).collect(Collectors.toSet());
    }
    
    public FacultyV1 create(FacultyV1 faculty) {
        if (!faculties.containsValue(faculty)) {
            faculty.setId(++idCounter);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }
    
    public FacultyV1 get(Long id) {
        return faculties.get(id);
    }
    
    public FacultyV1 update(long id, FacultyV1 faculty) {
        if (faculties.containsKey(id)) {
            faculty.setId(id);
            faculties.put(id, faculty);
            return faculty;
        }
        return null;
    }
    
    public FacultyV1 delete(Long id) {
        return faculties.remove(id);
    }
}
