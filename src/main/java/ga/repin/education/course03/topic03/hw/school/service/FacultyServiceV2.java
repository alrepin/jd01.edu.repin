package ga.repin.education.course03.topic03.hw.school.service;

import ga.repin.education.course03.topic03.hw.school.model.FacultyV2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV2 {
    private final Map<Long, FacultyV2> faculties = new HashMap<>();
    private Long idCounter = 0L;
    
    public Collection<FacultyV2> getFaculties(String color) {
        if (color == null) {
            return faculties.values();
        }
        return faculties.values().stream().filter(f -> f.getColor().equals(color)).collect(Collectors.toSet());
    }
    
    public FacultyV2 create(FacultyV2 facultyV2) {
        if (!faculties.containsValue(facultyV2)) {
            facultyV2.setId(++idCounter);
            faculties.put(facultyV2.getId(), facultyV2);
            return facultyV2;
        }
        return null;
    }
    
    public FacultyV2 get(Long id) {
        return faculties.get(id);
    }
    
    public FacultyV2 update(long id, FacultyV2 facultyV2) {
        if (faculties.containsKey(id)) {
            facultyV2.setId(id);
            faculties.put(id, facultyV2);
            return facultyV2;
        }
        return null;
    }
    
    public FacultyV2 delete(Long id) {
        return faculties.remove(id);
    }
}
