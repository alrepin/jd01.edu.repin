package ga.repin.education.course03.topic03.hw.school.repository;

import ga.repin.education.course03.topic03.hw.school.model.Faculty;
import ga.repin.education.course03.topic03.hw.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByColor(String color);
}
