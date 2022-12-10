package ga.repin.education.course03.topic05.hw.v4school.repository;

import ga.repin.education.course03.topic05.hw.v4school.model.AvatarV4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepositoryV4 extends JpaRepository<AvatarV4, Long> {
    Optional<AvatarV4> findByStudentId(Long id);
}
