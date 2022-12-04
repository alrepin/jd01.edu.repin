package ga.repin.education.course03.topic03.hw.v2school.repository;

import ga.repin.education.course03.topic03.hw.v2school.model.StudentV2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepositoryV2 extends JpaRepository<StudentV2, Long> {
    boolean existsByName(String name);
    Collection<StudentV2> findByAge(int age);
}
