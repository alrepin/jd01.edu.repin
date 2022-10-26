package ga.repin.education.course02.topic12.hw.calculator;
import ga.repin.education.common.exceptions.ErrorMessage;
import ga.repin.education.common.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ga.repin.education.course02.topic12.hw.HwConstants.*;

@RequestMapping(HW_ENDPOINT)
@RestController
public class CalculatorControllerV2 {
    private final CalculatorServiceV2 calculatorServiceV2;

    public CalculatorControllerV2(CalculatorServiceV2 calculatorServiceV2) {
        this.calculatorServiceV2 = calculatorServiceV2;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage()));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorMessage> handleException(HttpException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorMessage(exception.getHttpStatus(),exception.getMessage()));
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
