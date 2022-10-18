package ga.repin.education;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("session")
public class WelcomeController {
    private final WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping
    public String showIndexPage() {
        return welcomeService.operationIndex();
    }

    @GetMapping(path = "/exit")
    public String stopServer(@RequestParam(value = "pass", required = false) String pass) {
        return welcomeService.stopSpring(pass);
    }

    @GetMapping(path = "/switchtheme")
    public String switchTheme() {
        return welcomeService.letSwitchTheme();
    }

}
