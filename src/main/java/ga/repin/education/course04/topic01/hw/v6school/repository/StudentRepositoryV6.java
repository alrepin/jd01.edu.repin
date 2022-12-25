package ga.repin.education.course04.topic01.hw.v6school.repository;

import ga.repin.education.course04.topic01.hw.v6school.entity.StudentV6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepositoryV6 extends JpaRepository<StudentV6, Long> {
    boolean existsByName(String name);
    
    Collection<StudentV6> findByAge(int age);
    
    Collection<StudentV6> findByAgeBetween(Integer minAge, Integer maxAge);
    
    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer queryCalculateTotal();
    
    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Double queryCalculateAvgAge();
    
    @Query(value = "SELECT * FROM student ORDER BY id ASC OFFSET :offset", nativeQuery = true)
    List<StudentV6> queryListTail(Integer offset);
}
