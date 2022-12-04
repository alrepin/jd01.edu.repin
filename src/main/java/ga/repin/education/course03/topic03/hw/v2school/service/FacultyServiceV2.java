package ga.repin.education.course03.topic03.hw.v2school.service;

import ga.repin.education.course03.topic03.hw.v2school.model.FacultyV2;
import ga.repin.education.course03.topic03.hw.v2school.repository.FacultyRepositoryV2;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceV2 {
    
    private final FacultyRepositoryV2 facultyRepositoryV2;
    
    public FacultyServiceV2(FacultyRepositoryV2 facultyRepositoryV2) {
        this.facultyRepositoryV2 = facultyRepositoryV2;
    }
    
    public FacultyV2 create(FacultyV2 faculty) {
    
        Example<FacultyV2> e = Example.of(faculty);
        boolean exists = facultyRepositoryV2.exists(e);
    
        if (!exists) {
            return facultyRepositoryV2.save(faculty);
        }
        return null;
        
    }
    
    public FacultyV2 read(Long id) {
        return facultyRepositoryV2.findById(id).orElse(null);
    }
    
    public Collection<FacultyV2> filter(String color) {
        if (color == null) {
            return facultyRepositoryV2.findAll();
        }
        return facultyRepositoryV2.findByColor(color);
    }
    
    public FacultyV2 update(long id, FacultyV2 faculty) {
        if (facultyRepositoryV2.existsById(id)) {
            faculty.setId(id);
            return facultyRepositoryV2.save(faculty);
        }
        return null;
    }
    
    public FacultyV2 delete(Long id) {
        Optional<FacultyV2> f = facultyRepositoryV2.findById(id);
        if (f.isPresent()) {
            try {
                facultyRepositoryV2.deleteAll(f.stream().collect(Collectors.toList()));
            } catch (Exception e) {
                f = Optional.empty();
            } finally {
                return f.get();
            }
        }
        return null;
    }
}
