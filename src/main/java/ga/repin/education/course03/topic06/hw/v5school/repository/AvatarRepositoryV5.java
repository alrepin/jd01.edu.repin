package ga.repin.education.course03.topic06.hw.v5school.repository;

import ga.repin.education.course03.topic06.hw.v5school.model.AvatarV5;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepositoryV5 extends JpaRepository<AvatarV5, Long> {
    Optional<AvatarV5> findByStudentId(Long id);
}
