package ga.repin.education.course06.course_work.tbot.scheduler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import ga.repin.education.course06.course_work.tbot.entity.NotificationTask;
import ga.repin.education.course06.course_work.tbot.repository.NotificationTaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NotificationTaskScheduler {
    
    private final TelegramBot telegramBot;
    
    private final NotificationTaskRepository repository;
    
    public NotificationTaskScheduler(TelegramBot telegramBot, NotificationTaskRepository repository) {
        this.telegramBot = telegramBot;
        this.repository = repository;
    }
    
    @Scheduled(cron = "0 0/1 * * * *")
    public void sendNotifications() {
        final LocalDateTime nowDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        
        final List<NotificationTask> notificationTasks = repository.findAllByDateTimeLessThanEqual(nowDateTime);
        
        notificationTasks.forEach(this::sendNotification);
    }
    
    private void sendNotification(NotificationTask task) {
        final SendResponse response = telegramBot.execute(new SendMessage(task.getChatId(), "It's time to \n" + task.getText()));
        
        if (response.isOk()) {
            repository.delete(task);
        }
    }
}
