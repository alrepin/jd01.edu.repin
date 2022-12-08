package ga.repin.education.course03.topic05.hw.v4school.repository;

import ga.repin.education.course03.topic05.hw.v4school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByName(String name);
    
    Collection<Student> findByAge(int age);
    
    Collection<Student> findByAgeBetween(Integer minAge, Integer maxAge);
    
}
