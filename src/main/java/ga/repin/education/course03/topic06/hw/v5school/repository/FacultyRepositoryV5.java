package ga.repin.education.course03.topic06.hw.v5school.repository;

import ga.repin.education.course03.topic06.hw.v5school.model.FacultyV5;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepositoryV5 extends JpaRepository<FacultyV5, Long> {
    Collection<FacultyV5> findByColor(String color);
    
    Collection<FacultyV5> findByNameIgnoreCase(String name);
    
    Collection<FacultyV5> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<FacultyV5> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
