package ga.repin.course02.topic03.hw.calculator;

public interface CalculatorService {
    String operationIndex();

    String operationWelcome();
    String operationPlus(Double num1, Double num2);

    String operationMinus(Double num1, Double num2);

    String operationMultiply(Double num1, Double num2);

    String operationDivide(Double num1, Double num2);

}
