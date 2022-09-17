package ga.repin.education;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {
    private final Service service;

    public CalculatorController(Service service) {
        this.service = service;
    }

    @GetMapping
    public String showWelcomePage() {
        return service.operationWelcome();
    }

    @GetMapping(path = "/plus")
    public String getPlusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return service.operationPlus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String getMinusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return service.operationMinus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String getMultiplyCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return service.operationMultiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String getDivideCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return service.operationDivide(num1, num2);
    }

}
