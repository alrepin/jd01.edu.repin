package ga.repin.education.course04.topic05.hw.v8school.repository;

import ga.repin.education.course04.topic05.hw.v8school.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByColor(String color);
    
    Collection<Faculty> findByNameIgnoreCase(String name);
    
    Collection<Faculty> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
