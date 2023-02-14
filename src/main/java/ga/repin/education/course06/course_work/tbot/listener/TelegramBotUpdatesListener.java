package ga.repin.education.course06.course_work.tbot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ga.repin.education.course06.course_work.tbot.entity.NotificationTask;
import ga.repin.education.course06.course_work.tbot.repository.NotificationTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    
    private static final Pattern REGEX_PATTERN_CREATE_NOTIFICATION_MSG = Pattern.compile("(\\d{2}.\\d{2}.\\d{4} \\d{2}.\\d{2})(\\s)(.*)");
    
    private final TelegramBot telegramBot;
    
    private final NotificationTaskRepository notificationTaskRepository;
    
    public TelegramBotUpdatesListener(TelegramBot telegramBot, NotificationTaskRepository notificationTaskRepository) {
        this.telegramBot = telegramBot;
        this.notificationTaskRepository = notificationTaskRepository;
    }
    
    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }
    
    @Override
    public int process(List<Update> updates) {
        try {
            updates.forEach(this::processUpdate);
        } catch (Exception e) {
            
            LOGGER.debug(e.getMessage());
        } finally {
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }
        
    }
    
    private void processUpdate(Update update) {
        LOGGER.debug("Processing update: {}", update);
        Long chatId = null;
        String text = null;
        
        
        try {
            text = update.message().text();
            chatId = update.message().chat().id();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        }
        if (text == null || text.isBlank()) {
            sendMessage(chatId, "no message no funny!");
            return;
        }
        
        if ("/start".equals(text)) {
            hintMessage(chatId);
            return;
        }
        
        final Matcher matcher = REGEX_PATTERN_CREATE_NOTIFICATION_MSG
                .matcher(text);
        
        if (!matcher.matches()) {
            sendMessage(chatId, "dont understand you, dear)");
            return;
        }
        
        final String notificationDateTimeStr = matcher.group(1);
        
        final String notificationText = matcher.group(3);
        
        LocalDateTime notificationDateTime;
        try {
            notificationDateTime = LocalDateTime.parse(notificationDateTimeStr, DATE_TIME_FORMAT);
        } catch (Exception e) {
            sendMessage(chatId, e.getMessage().toUpperCase());
            return;
        }
        
        NotificationTask notificationRecord = new NotificationTask(chatId, notificationText, notificationDateTime);
        
        notificationRecord = notificationTaskRepository.save(notificationRecord);
        
        sendMessage(chatId, "will remind you about\n" + notificationRecord.getText() + "\n" +
                notificationRecord.getDateTime().format(DATE_TIME_FORMAT)
        );
    }
    
    private void hintMessage(Long chatId) {
        sendMessage(chatId, "Hi, you can use template from next msg to plan your reminders)");
        final String txtDateTemplate = String.format(LocalDateTime.now().plusMinutes(5).format(DATE_TIME_FORMAT));
        sendMessage(chatId, txtDateTemplate + " anything");
    }
    
    private void sendMessage(Long chatId, String text) {
        telegramBot.execute(new SendMessage(chatId, text));
    }
}
