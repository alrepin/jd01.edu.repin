package ga.repin.education.course03.topic06.hw.v5school.repository;

import ga.repin.education.course03.topic06.hw.v5school.model.StudentV5;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepositoryV5 extends JpaRepository<StudentV5, Long> {
    boolean existsByName(String name);
    
    Collection<StudentV5> findByAge(int age);
    
    Collection<StudentV5> findByAgeBetween(Integer minAge, Integer maxAge);
    
}
