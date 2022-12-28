package ga.repin.education.course04.topic05.hw.v8school.repository;

import ga.repin.education.course04.topic05.hw.v8school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByName(String name);
    
    Collection<Student> findByAge(int age);
    
    Collection<Student> findByAgeBetween(Integer minAge, Integer maxAge);
    
    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer queryCalculateTotal();
    
    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Double queryCalculateAvgAge();
    
    @Query(value = "SELECT * FROM student ORDER BY id ASC OFFSET :offset", nativeQuery = true)
    List<Student> queryListTail(Integer offset);
}
