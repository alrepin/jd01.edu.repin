package ga.repin.education.course04.topic04.hw.v7school.repository;

import ga.repin.education.course04.topic04.hw.v7school.entity.FacultyV7;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepositoryV7 extends JpaRepository<FacultyV7, Long> {
    Collection<FacultyV7> findByColor(String color);
    
    Collection<FacultyV7> findByNameIgnoreCase(String name);
    
    Collection<FacultyV7> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<FacultyV7> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
