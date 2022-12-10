package ga.repin.education.course03.topic05.hw.v4school.repository;

import ga.repin.education.course03.topic05.hw.v4school.model.StudentV4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepositoryV4 extends JpaRepository<StudentV4, Long> {
    boolean existsByName(String name);
    
    Collection<StudentV4> findByAge(int age);
    
    Collection<StudentV4> findByAgeBetween(Integer minAge, Integer maxAge);
    
}
