import ga.repin.course01.course_work.Cw01;
import ga.repin.course01.topic01.hw.Hw01;
import ga.repin.course01.topic02.hw.Hw02;
import ga.repin.course01.topic03.hw.Hw03;
import ga.repin.course01.topic04.hw.Hw04;
import ga.repin.course01.topic05.hw.Hw05;
import ga.repin.course01.topic06.hw.Hw06;
import ga.repin.course01.topic07.hw.Hw07;
import ga.repin.course01.topic08.hw.Hw08;
import ga.repin.course01.topic09.hw.Hw09;
import ga.repin.course01.topic10.hw.Hw10;
import ga.repin.course02.topic02_2.hw.Hw02_2;
import ga.repin.creation.Common;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

public class Main {
    public static void main(String[] args) {
        Common.hwCaption("Установка инструментов разработчика", true, 16819);
        Hw01.main();
        Common.hwCaption("Переменные", true, 16820);
        Hw02.main();
        Common.hwCaption("Условные операторы", true, 16821);
        Hw03.main();
        Common.hwCaption("Циклы", true, 16822);
        Hw04.main();
        Common.hwCaption("Массивы", true, 16823);
        Hw05.main();
        Common.hwCaption("Массивы ч.2", true, 16824);
        Hw06.main();
        Common.hwCaption("Строки", true, 16825);
        Hw07.main();
        Common.hwCaption("Методы", true, 16826);
        Hw08.main();
        Common.hwCaption("Объекты и классы", true, 16827);
        Hw09.main();
        Common.hwCaption("Методы объектов", true, 16828);
        Hw10.main();
        Cw01.main();
        Common.hwCaption("ООП — инкапсуляция и наследование ч. 1", true, 16831);
        ga.repin.course02.topic02.hw.Hw02.main();
        Common.hwCaption("ООП — полиморфизм и интерфейсы (ч2)", true, 16832);
        Hw02_2.main();
        Common.hwCaption("2.3. Введение в Maven и Spring Boot", true, 16833);
        ga.repin.course02.topic03.hw.calculator.CalculatorApplication.main(args);
    }
}