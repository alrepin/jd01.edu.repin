package ga.repin.education.course03.topic05.hw.v4school.repository;

import ga.repin.education.course03.topic05.hw.v4school.model.FacultyV4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepositoryV4 extends JpaRepository<FacultyV4, Long> {
    Collection<FacultyV4> findByColor(String color);
    
    Collection<FacultyV4> findByNameIgnoreCase(String name);
    
    Collection<FacultyV4> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<FacultyV4> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
