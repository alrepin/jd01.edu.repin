package ga.repin.education.course03.topic03.hw.school.service;

import ga.repin.education.course03.topic03.hw.school.model.Faculty;
import ga.repin.education.course03.topic03.hw.school.model.Student;
import ga.repin.education.course03.topic03.hw.school.repository.FacultyRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    
    public Collection<Faculty> filter(String color) {
        if (color == null) {
            return facultyRepository.findAll();
        }
        return facultyRepository.findByColor(color);
    }
    
    public Faculty update(long id, Faculty faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public Faculty delete(Long id) {
        Optional<Faculty> f = facultyRepository.findById(id);
        if (f.isPresent()) {
            try {
                facultyRepository.deleteAll(f.stream().collect(Collectors.toList()));
            } catch (Exception e) {
                f = Optional.empty();
            } finally {
                return f.get();
            }
        }
        return null;
    }
}
