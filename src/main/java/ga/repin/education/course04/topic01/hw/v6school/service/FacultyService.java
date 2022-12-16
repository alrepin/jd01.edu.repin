package ga.repin.education.course04.topic01.hw.v6school.service;

import ga.repin.education.course04.topic01.hw.v6school.entity.Faculty;
import ga.repin.education.course04.topic01.hw.v6school.entity.Student;
import ga.repin.education.course04.topic01.hw.v6school.repository.FacultyRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    
    private final FacultyRepository facultyRepository;
    
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public Faculty create(Faculty faculty) {
        
        Example<Faculty> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            return facultyRepository.save(faculty);
        }
        return null;
        
    }
    
    public Faculty read(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<Student> studentsByFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).map(Faculty::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<Faculty> filter(String query, String color) {
        if (query != null && !query.isBlank() && color != null && !color.isBlank()) {
            return facultyRepository.findByNameIgnoreCaseAndColor(query, color);
        } else if ((query == null || query.isBlank()) && (color != null && !color.isBlank())) {
            return facultyRepository.findByColor(color);
        } else if (query != null && !query.isBlank()) {
            return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(query, query);
        } else if ((query == null || query.isBlank()) && (color == null || color.isBlank())) {
            return facultyRepository.findAll();
        }
        return null;
    }
    
    public Faculty update(long id, Faculty faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public Faculty delete(Long id) {
        Optional<Faculty> currentFaculty = facultyRepository.findById(id);
        if (currentFaculty.isPresent()) {
            try {
                facultyRepository.deleteAll(currentFaculty.stream().collect(Collectors.toList()));
            } catch (Exception e) {
                //currentFaculty = Optional.empty();
            } finally {
                return currentFaculty.orElse(null);
            }
        }
        return null;
    }
}
