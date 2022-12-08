package ga.repin.education.course03.topic04.hw.v3school.repository;

import ga.repin.education.course03.topic04.hw.v3school.model.FacultyV3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepositoryV3 extends JpaRepository<FacultyV3, Long> {
    Collection<FacultyV3> findByColor(String color);
    
    Collection<FacultyV3> findByNameIgnoreCase(String name);
    
    Collection<FacultyV3> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<FacultyV3> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
