package ga.repin.education.navigation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static ga.repin.education.navigation.NavigationConstants.*;

@RestController
public class Course02Controller {
    private final Course02Service course02Service;

    public Course02Controller(Course02Service course02Service) {
        this.course02Service = course02Service;
    }

    @GetMapping(path = ROOT_URL_02)
    public String showIndexPage() {
        return course02Service.operationIndex();
    }

}
