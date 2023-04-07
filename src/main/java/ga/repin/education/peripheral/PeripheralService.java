package ga.repin.education.peripheral;

import ga.repin.education.course06.course_work.tbot.entity.NotificationTask;

import java.util.List;
import java.util.Map;

public interface PeripheralService {
    
    String course1Index();
    
    String course2Index();
    
    String course3Index();
    
    String course4Index();
    
    String course5Index();
    
    String course6Index();
    
    String course7Index();
    
    String course8Index();
    
    String course9Index();
    
    String stopSpring(String pass);
    
    String letSwitchTheme();
    
    String getServerPort();
    
    String getServerPort(String description);
    
    Map<String, String> task040504();
    
    void task040601();
    
    void task040602();
    
    List<NotificationTask> notificationsList();
}
