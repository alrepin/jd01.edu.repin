package ga.repin.education.course03.topic04.hw.v3school.service;

import ga.repin.education.course03.topic04.hw.v3school.model.FacultyV3;
import ga.repin.education.course03.topic04.hw.v3school.model.StudentV3;
import ga.repin.education.course03.topic04.hw.v3school.repository.FacultyRepositoryV3;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV3 {
    
    private final FacultyRepositoryV3 facultyRepository;
    
    public FacultyServiceV3(FacultyRepositoryV3 facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public FacultyV3 create(FacultyV3 faculty) {
        
        Example<FacultyV3> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            return facultyRepository.save(faculty);
        }
        return null;
        
    }
    
    public FacultyV3 read(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV3> studentsByFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).map(FacultyV3::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<FacultyV3> filter(String query, String color) {
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
    
    public FacultyV3 update(long id, FacultyV3 faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public FacultyV3 delete(Long id) {
        Optional<FacultyV3> f = facultyRepository.findById(id);
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
