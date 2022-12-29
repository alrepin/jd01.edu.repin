package ga.repin.education.course04.topic05.hw.v8school.service;

import ga.repin.education.course04.topic05.hw.v8school.entity.Faculty;
import ga.repin.education.course04.topic05.hw.v8school.entity.Student;
import ga.repin.education.course04.topic05.hw.v8school.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    
    private final FacultyRepository facultyRepository;
    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);
    
    public FacultyService(FacultyRepository facultyRepository) {
        logger.debug("Service wire with Repository");
        this.facultyRepository = facultyRepository;
    }
    
    public Faculty create(Faculty faculty) {
        logger.info("Method create was invoked");
        Example<Faculty> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            logger.debug("Not double - create");
            return facultyRepository.save(faculty);
        }
        logger.error("Not created cause double");
        return null;
        
    }
    
    public Faculty read(Long id) {
        logger.info("Method read was invoked");
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<Student> studentsByFaculty(Long facultyId) {
        logger.info("Method studentsByFaculty was invoked");
        return facultyRepository.findById(facultyId).map(Faculty::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<Faculty> filter(String query, String color) {
        logger.info("Method filter was invoked");
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
        logger.info("Method update was invoked");
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public Faculty delete(Long id) {
        logger.info("Method delete was invoked");
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
    
    public String longestFacultyName() {
        logger.info("Method longestFacultyName was invoked");
        return facultyRepository.findAll()
                .stream()
                .map(Faculty::getName)
                .max(Comparator.comparing(String::length))
                .orElse(null);
    }
    
}
