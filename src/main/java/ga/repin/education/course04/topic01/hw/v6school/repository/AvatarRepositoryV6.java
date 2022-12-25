package ga.repin.education.course04.topic01.hw.v6school.repository;

import ga.repin.education.course04.topic01.hw.v6school.entity.AvatarV6;
import ga.repin.education.course04.topic01.hw.v6school.entity.AvatarInfoV6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AvatarRepositoryV6 extends JpaRepository<AvatarV6, Long> {
    Optional<AvatarV6> findByStudentId(Long id);
    
    @Query(value = "SELECT a.id         AS avatar_id,\n" +
            "             s.name       AS student_name,\n" +
            "             a.file_path  AS avatar_file_path,\n" +
            "             a.file_size  AS avatar_file_size,\n" +
            "             a.media_type AS avatar_media_type\n" +
            "      FROM avatar AS a\n" +
            "               JOIN student as s\n" +
            "                    ON a.student_id = s.id\n" +
            "LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<AvatarInfoV6> queryListAvatarInfo(Integer offset, Integer limit);
}
