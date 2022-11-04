package ga.repin.education.navigation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static ga.repin.education.navigation.NavigationConstants.*;

@RestController
public class Course01Controller {
    private final Course01Service course01Service;

    public Course01Controller(Course01Service course01Service) {
        this.course01Service = course01Service;
    }

    @GetMapping(path = ROOT_URL_01)
    public String showIndexPage() {
        return course01Service.operationIndex();
    }

    @GetMapping(path = "/exit")
    public String stopServer(@RequestParam(value = "pass", required = false) String pass) {
        return course01Service.stopSpring(pass);
    }

    @GetMapping(path = "/switchtheme")
    public String switchTheme() {
        return course01Service.letSwitchTheme();
    }

}
