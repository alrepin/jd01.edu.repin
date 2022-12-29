package ga.repin.education.navigation;

import java.util.Map;

public interface IndexService {
    String course1Index();
    
    String course2Index();
    
    String course3Index();
    String course4Index();
    
    String stopSpring(String pass);

    String letSwitchTheme();
    
    String getServerPort();
    
    String getServerPort(String description);
    
    Map<String, String> task040504();
}
