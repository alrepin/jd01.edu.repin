package ga.repin.education.course04.topic01.hw.v6school.repository;

import ga.repin.education.course04.topic01.hw.v6school.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long id);
}
