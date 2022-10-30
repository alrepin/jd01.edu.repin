package ga.repin.education.course02.topic12.hw.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static ga.repin.education.course02.topic12.hw.HwConstants.HW_ENDPOINT;
import static ga.repin.education.common.HtmlWrappers.*;

@Service
public class CalculatorServiceImplV2 implements CalculatorServiceV2 {

    private final String descriptionPlus = "should add num1 and num2 and return the result in the format \"5 + 5 = 10\"";
    private final String descriptionMinus = "should subtract num2 from num1 and return the result as \"5 − 5 = 0\"";
    private final String descriptionMultiply = "should multiply num1 by num2 and return the result as \"5 * 5 = 25\"";
    private final String descriptionDivide = " should divide num1 by num2 and return the result as \"5 / 5 = 1\"";

    @Value("${session.timeout}")
    private Integer sessionTimeout;
    public String operationWelcome() {
        return mainTheme(
                "Welcome to Calculator))" + HR +
                        hrefPrep(HW_ENDPOINT + "/plus?num1=5&num2=5", "[ADDITION] ") +
                        descriptionPlus + ";" + BR +
                        hrefPrep(HW_ENDPOINT + "/minus?num1=5&num2=5", "[SUBTRACTION] ") +
                        descriptionMinus + ";" + BR +
                        hrefPrep(HW_ENDPOINT + "/multiply?num1=5&num2=5", "[MULTIPLICATION] ") +
                        descriptionMultiply + ";" + BR +
                        hrefPrep(HW_ENDPOINT + "/divide?num1=5&num2=5", "[DIVISION] ") +
                        descriptionDivide + "."
        );
    }

    public String operationPlus(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return mainTheme(descriptionPlus);
        }
        return mainTheme(descriptionPlus + "<hr>"
                + num1 + " + " + num2 + " = " + (num1 + num2)
        );
    }

    public String operationMinus(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return mainTheme(descriptionMinus);
        }
        return mainTheme(descriptionMinus + "<hr>"
                + num1 + " - " + num2 + " = " + (num1 - num2)
        );
    }

    public String operationMultiply(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return mainTheme(descriptionMultiply);
        }
        return mainTheme(descriptionMultiply + "<hr>"
                + num1 + " * " + num2 + " = " + (num1 * num2)
        );
    }

    public String operationDivide(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return mainTheme(descriptionDivide);
        }
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by 0 is impossible!");
        }
        return mainTheme(descriptionDivide + HR +
                num1 + " / " + num2 + " = " + (num1 / num2)
        );
    }
}
