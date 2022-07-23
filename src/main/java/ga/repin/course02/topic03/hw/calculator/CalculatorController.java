package ga.repin.course02.topic03.hw.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping
    public String showIndexPage() {
        return "404";
    }
}
