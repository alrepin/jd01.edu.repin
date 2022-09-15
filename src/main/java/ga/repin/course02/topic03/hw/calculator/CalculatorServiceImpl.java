package ga.repin.course02.topic03.hw.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{


    private String htmlFormat(String unformattedString) {
        return "<html><body link=\"red\" vlink=\"red\" bgcolor=\"black\" text=\"# 7FFF00\"><h2>"
                + unformattedString
                + "<hr><a href=\"/.\">[ДОМОЙ]</a>   <a href=\".\">[НАЗАД]</a><hr>"
                + "</h2></body></html>";
    }

    public String operationIndex() {

        return htmlFormat("Для работы с калькулятором перейдите по ссылке: "
                + "<hr><a href=\"/calculator\">[КАЛЬКУЛЯТОР]</a>");
    }

    private String descriptionPlus = "должен сложить num1 и num2 и вернуть результат в формате “5 + 5 = 10”";
    private String descriptionMinus = "должен вычесть из num1 num2 и вернуть результат в формате “5 − 5 = 0”";
    private String descriptionMultiply = "должен умножить num1 на num2 и вернуть результат в формате “5 * 5 = 25”";
    private String descriptionDivide = "должен разделить num1 на num2 и вернуть результат в формате “5 / 5 = 1”";

    public String operationWelcome() {
        return htmlFormat("Добро пожаловать в калькулятор"
                + "<hr><a href=\"/calculator/plus?num1=5&num2=5\">[СЛОЖЕНИЕ]</a> - "
                + descriptionPlus + ";"
                + "<br><a href=\"/calculator/minus?num1=5&num2=5\">[ВЫЧИТАНИЕ]</a> - "
                + descriptionMinus + ";"
                + "<br><a href=\"/calculator/multiply?num1=5&num2=5\">[УМНОЖЕНИЕ]</a> - "
                + descriptionMultiply + ";"
                + "<br><a href=\"/calculator/divide?num1=5&num2=5\">[ДЕЛЕНИЕ]</a> - "
                + descriptionDivide + "."
        );
    }

    public String operationPlus(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return htmlFormat(descriptionPlus);
        }
        return htmlFormat(descriptionPlus + "<hr>"
                + num1 + " + " + num2 + " = " + (num1 + num2)
        );
    }

    public String operationMinus(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return htmlFormat(descriptionMinus);
        }
        return htmlFormat(descriptionMinus + "<hr>"
                + num1 + " - " + num2 + " = " + (num1 - num2)
        );
    }

    public String operationMultiply(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return htmlFormat(descriptionMultiply);
        }
        return htmlFormat(descriptionMultiply + "<hr>"
                + num1 + " * " + num2 + " = " + (num1 * num2)
        );
    }

    public String operationDivide(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return htmlFormat(descriptionDivide);
        }
        if (num2 == 0) {
            return htmlFormat("Деление на 0 невозможно!");
        }
        return htmlFormat(descriptionDivide + "<hr>"
                + num1 + " / " + num2 + " = " + (num1 / num2)
        );
    }

}
