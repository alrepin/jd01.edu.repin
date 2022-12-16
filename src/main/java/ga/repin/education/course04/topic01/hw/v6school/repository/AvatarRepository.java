package ga.repin.education.course04.topic01.hw.v6school.repository;

import ga.repin.education.course04.topic01.hw.v6school.entity.Avatar;
import ga.repin.education.course04.topic01.hw.v6school.entity.AvatarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long id);
    
    @Query(value = "SELECT a.id         AS avatar_id,\n" +
            "             s.name       AS student_name,\n" +
            "             a.file_path  AS avatar_file_path,\n" +
            "             a.file_size  AS avatar_file_size,\n" +
            "             a.media_type AS avatar_media_type\n" +
            "      FROM avatar AS a\n" +
            "               JOIN student as s\n" +
            "                    ON a.student_id = s.id\n" +
            "LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<AvatarInfo> queryListAvatarInfo(Integer offset, Integer limit);
}
