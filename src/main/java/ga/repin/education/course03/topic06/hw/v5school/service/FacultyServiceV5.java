package ga.repin.education.course03.topic06.hw.v5school.service;

import ga.repin.education.course03.topic06.hw.v5school.model.FacultyV5;
import ga.repin.education.course03.topic06.hw.v5school.model.StudentV5;
import ga.repin.education.course03.topic06.hw.v5school.repository.FacultyRepositoryV5;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV5 {
    
    private final FacultyRepositoryV5 facultyRepository;
    
    public FacultyServiceV5(FacultyRepositoryV5 facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public FacultyV5 create(FacultyV5 faculty) {
        
        Example<FacultyV5> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            return facultyRepository.save(faculty);
        }
        return null;
        
    }
    
    public FacultyV5 read(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV5> studentsByFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).map(FacultyV5::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<FacultyV5> filter(String query, String color) {
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
    
    public FacultyV5 update(long id, FacultyV5 faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public FacultyV5 delete(Long id) {
        Optional<FacultyV5> currentFaculty = facultyRepository.findById(id);
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
