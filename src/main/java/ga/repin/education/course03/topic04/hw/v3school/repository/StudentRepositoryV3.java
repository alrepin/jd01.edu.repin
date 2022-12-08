package ga.repin.education.course03.topic04.hw.v3school.repository;

import ga.repin.education.course03.topic04.hw.v3school.model.StudentV3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepositoryV3 extends JpaRepository<StudentV3, Long> {
    boolean existsByName(String name);
    
    Collection<StudentV3> findByAge(int age);
    
    Collection<StudentV3> findByAgeBetween(Integer minAge, Integer maxAge);
    
}
