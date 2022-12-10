package ga.repin.education.course03.topic05.hw.v4school.service;

import ga.repin.education.course03.topic05.hw.v4school.model.FacultyV4;
import ga.repin.education.course03.topic05.hw.v4school.model.StudentV4;
import ga.repin.education.course03.topic05.hw.v4school.repository.FacultyRepositoryV4;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV4 {
    
    private final FacultyRepositoryV4 facultyRepository;
    
    public FacultyServiceV4(FacultyRepositoryV4 facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public FacultyV4 create(FacultyV4 faculty) {
        
        Example<FacultyV4> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            return facultyRepository.save(faculty);
        }
        return null;
        
    }
    
    public FacultyV4 read(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV4> studentsByFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).map(FacultyV4::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<FacultyV4> filter(String query, String color) {
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
    
    public FacultyV4 update(long id, FacultyV4 faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public FacultyV4 delete(Long id) {
        Optional<FacultyV4> f = facultyRepository.findById(id);
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
