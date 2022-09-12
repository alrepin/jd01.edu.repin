package ga.repin.course02.topic03.hw.calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showIndexPage() {
        return calculatorService.operationIndex();
    }

    @GetMapping(path = "/calculator")
    public String showWelcomePage() {
        return calculatorService.operationWelcome();
    }

    @GetMapping(path = "/calculator/plus")
    public String getPlusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationPlus(num1, num2);
    }

    @GetMapping(path = "/calculator/minus")
    public String getMinusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationMinus(num1, num2);
    }

    @GetMapping(path = "/calculator/multiply")
    public String getMultiplyCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationMultiply(num1, num2);
    }

    @GetMapping(path = "/calculator/divide")
    public String getDivideCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.operationDivide(num1, num2);
    }

}
