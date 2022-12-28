package ga.repin.education.course04.topic04.hw.v7school.service;

import ga.repin.education.course04.topic04.hw.v7school.entity.FacultyV7;
import ga.repin.education.course04.topic04.hw.v7school.repository.FacultyRepositoryV7;
import ga.repin.education.course04.topic04.hw.v7school.entity.StudentV7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV7 {
    
    private final FacultyRepositoryV7 facultyRepository;
    private final Logger logger = LoggerFactory.getLogger(FacultyServiceV7.class);
    
    public FacultyServiceV7(FacultyRepositoryV7 facultyRepository) {
        logger.debug("Service wire with Repository");
        this.facultyRepository = facultyRepository;
    }
    
    public FacultyV7 create(FacultyV7 faculty) {
        logger.info("Method create was invoked");
        Example<FacultyV7> e = Example.of(faculty);
        boolean exists = facultyRepository.exists(e);
        
        if (!exists) {
            logger.debug("Not double - create");
            return facultyRepository.save(faculty);
        }
        logger.error("Not created cause double");
        return null;
        
    }
    
    public FacultyV7 read(Long id) {
        logger.info("Method read was invoked");
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Collection<StudentV7> studentsByFaculty(Long facultyId) {
        logger.info("Method studentsByFaculty was invoked");
        return facultyRepository.findById(facultyId).map(FacultyV7::getStudents)
                .orElseGet(Collections::emptyList);
    }
    
    public Collection<FacultyV7> filter(String query, String color) {
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
    
    public FacultyV7 update(long id, FacultyV7 faculty) {
        logger.info("Method update was invoked");
        if (facultyRepository.existsById(id)) {
            faculty.setId(id);
            return facultyRepository.save(faculty);
        }
        return null;
    }
    
    public FacultyV7 delete(Long id) {
        logger.info("Method delete was invoked");
        Optional<FacultyV7> currentFaculty = facultyRepository.findById(id);
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
