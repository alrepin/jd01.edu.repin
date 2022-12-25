package ga.repin.education.course04.topic01.hw.v6school.repository;

import ga.repin.education.course04.topic01.hw.v6school.entity.FacultyV6;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepositoryV6 extends JpaRepository<FacultyV6, Long> {
    Collection<FacultyV6> findByColor(String color);
    
    Collection<FacultyV6> findByNameIgnoreCase(String name);
    
    Collection<FacultyV6> findByNameIgnoreCaseAndColor(String name, String color);
    
    Collection<FacultyV6> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
    
}
