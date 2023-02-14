package ga.repin.education.course06.course_work.tbot.repository;

import ga.repin.education.course06.course_work.tbot.entity.NotificationTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {
    
    List<NotificationTask> findAllByDateTimeLessThanEqual(LocalDateTime dateTime);
}
