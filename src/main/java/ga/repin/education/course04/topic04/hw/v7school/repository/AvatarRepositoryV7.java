package ga.repin.education.course04.topic04.hw.v7school.repository;

import ga.repin.education.course04.topic04.hw.v7school.entity.AvatarV7;
import ga.repin.education.course04.topic04.hw.v7school.entity.AvatarInfoV7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AvatarRepositoryV7 extends JpaRepository<AvatarV7, Long> {
    Optional<AvatarV7> findByStudentId(Long id);
    
    @Query(value = "SELECT a.id         AS avatar_id,\n" +
            "             s.id         AS student_id,\n" +
            "             s.name       AS student_name,\n" +
            "             a.file_path  AS avatar_file_path,\n" +
            "             a.file_size  AS avatar_file_size,\n" +
            "             a.media_type AS avatar_media_type\n" +
            "      FROM avatar AS a\n" +
            "               JOIN student as s\n" +
            "                    ON a.student_id = s.id\n" +
            "ORDER BY a.id\n" +
            "LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<AvatarInfoV7> queryListAvatarInfo(Integer offset, Integer limit);
}
