package ga.repin.education.course03.topic06.hw.v5school.repository;

import ga.repin.education.course03.topic06.hw.v5school.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long id);
}
