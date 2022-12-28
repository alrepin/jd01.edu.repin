package ga.repin.education.course04.topic04.hw.v7school.repository;

import ga.repin.education.course04.topic04.hw.v7school.entity.StudentV7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepositoryV7 extends JpaRepository<StudentV7, Long> {
    boolean existsByName(String name);
    
    Collection<StudentV7> findByAge(int age);
    
    Collection<StudentV7> findByAgeBetween(Integer minAge, Integer maxAge);
    
    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer queryCalculateTotal();
    
    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Double queryCalculateAvgAge();
    
    @Query(value = "SELECT * FROM student ORDER BY id ASC OFFSET :offset", nativeQuery = true)
    List<StudentV7> queryListTail(Integer offset);
}
