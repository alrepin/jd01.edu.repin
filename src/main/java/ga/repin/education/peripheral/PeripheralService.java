package ga.repin.education.peripheral;

import java.util.Map;

public interface PeripheralService {
    String course1Index();
    
    String course2Index();
    
    String course3Index();
    String course4Index();
    
    String course5Index();
    
    String course6Index();
    
    String stopSpring(String pass);

    String letSwitchTheme();
    
    String getServerPort();
    
    String getServerPort(String description);
    
    Map<String, String> task040504();
    
    void task040601();
    
    void task040602();
}
