package ga.repin.education.course02.topic03.hw.calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping
    public String showWelcomePage() {
        return calculatorService.operationWelcome();
    }

    @GetMapping(path = "/plus")
    public String getPlusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationPlus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String getMinusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationMinus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String getMultiplyCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationMultiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String getDivideCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationDivide(num1, num2);
    }

}
