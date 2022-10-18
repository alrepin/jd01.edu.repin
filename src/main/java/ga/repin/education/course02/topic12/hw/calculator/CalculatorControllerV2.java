package ga.repin.education.course02.topic12.hw.calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static ga.repin.education.course02.topic12.hw.HwConstants.*;

@RequestMapping(HW_ENDPOINT)
@RestController
public class CalculatorControllerV2 {
    private final CalculatorServiceV2 calculatorServiceV2;

    public CalculatorControllerV2(CalculatorServiceV2 calculatorServiceV2) {
        this.calculatorServiceV2 = calculatorServiceV2;
    }


    @GetMapping
    public String showWelcomePage() {
        return calculatorServiceV2.operationWelcome();
    }

    @GetMapping(path = "/plus")
    public String getPlusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorServiceV2.operationPlus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String getMinusCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorServiceV2.operationMinus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String getMultiplyCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorServiceV2.operationMultiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String getDivideCalculator(@RequestParam(value = "num1",
            required = false) Double num1, @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorServiceV2.operationDivide(num1, num2);
    }

}
