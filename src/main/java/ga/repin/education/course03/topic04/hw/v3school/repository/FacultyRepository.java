package ga.repin.education.course03.topic04.hw.v3school.repository;

import ga.repin.education.course03.topic04.hw.v3school.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByColor(String color);
    
    Collection<Faculty> findByNameIgnoreCase(String name);
    
    Collection<Faculty> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
