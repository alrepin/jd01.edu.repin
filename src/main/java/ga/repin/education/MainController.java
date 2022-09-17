package ga.repin.education;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final Service service;

    public MainController(Service service) {
        this.service = service;
    }

    @GetMapping
    public String showIndexPage() {
        return service.operationIndex();
    }



}
