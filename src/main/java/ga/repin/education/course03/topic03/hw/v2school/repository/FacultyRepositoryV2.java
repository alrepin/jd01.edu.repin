package ga.repin.education.course03.topic03.hw.v2school.repository;

import ga.repin.education.course03.topic03.hw.v2school.model.FacultyV2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepositoryV2 extends JpaRepository<FacultyV2, Long> {
    Collection<FacultyV2> findByColor(String color);
}
