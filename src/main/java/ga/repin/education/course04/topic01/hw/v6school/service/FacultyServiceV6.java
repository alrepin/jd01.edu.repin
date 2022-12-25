package ga.repin.education.course04.topic01.hw.v6school.service;

import ga.repin.education.course04.topic01.hw.v6school.entity.FacultyV6;
import ga.repin.education.course04.topic01.hw.v6school.entity.StudentV6;
import ga.repin.education.course04.topic01.hw.v6school.repository.FacultyRepositoryV6;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV6 {
    
    private final FacultyRepositoryV6 facultyRepository;
    
    public FacultyServiceV6(FacultyRepositoryV6 facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public FacultyV6 create(FacultyV6 faculty) {
        
        Example<FacultyV6> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            return facultyRepository.save(faculty);
        }
        return null;
        
    }
    
    public FacultyV6 read(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV6> studentsByFaculty(Long facultyId) {
        return facultyRepository.findById(facultyId).map(FacultyV6::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<FacultyV6> filter(String query, String color) {
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
    
    public FacultyV6 update(long id, FacultyV6 faculty) {
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public FacultyV6 delete(Long id) {
        Optional<FacultyV6> currentFaculty = facultyRepository.findById(id);
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
