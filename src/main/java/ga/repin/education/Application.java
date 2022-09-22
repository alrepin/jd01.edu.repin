package ga.repin.education;

import ga.repin.education.creation.Common;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
	public static ApplicationContext appContext = null;
	public static void main(String[] args) {
		Common.hwCaption("Установка инструментов разработчика", true, 16819);
		ga.repin.education.course01.topic01.hw.Hw01.main();
		Common.hwCaption("Переменные", true, 16820);
		ga.repin.education.course01.topic02.hw.Hw02.main();
		Common.hwCaption("Условные операторы", true, 16821);
		ga.repin.education.course01.topic03.hw.Hw03.main();
		Common.hwCaption("Циклы", true, 16822);
		ga.repin.education.course01.topic04.hw.Hw04.main();
		Common.hwCaption("Массивы", true, 16823);
		ga.repin.education.course01.topic05.hw.Hw05.main();
		Common.hwCaption("Массивы ч.2", true, 16824);
		ga.repin.education.course01.topic06.hw.Hw06.main();
		Common.hwCaption("Строки", true, 16825);
		ga.repin.education.course01.topic07.hw.Hw07.main();
		Common.hwCaption("Методы", true, 16826);
		ga.repin.education.course01.topic08.hw.Hw08.main();
		Common.hwCaption("Объекты и классы", true, 16827);
		ga.repin.education.course01.topic09.hw.Hw09.main();
		Common.hwCaption("Методы объектов", true, 16828);
		ga.repin.education.course01.topic10.hw.Hw10.main();
		ga.repin.education.course01.course_work.Cw01.main();
		Common.hwCaption("ООП — инкапсуляция и наследование ч. 1", true, 16831);
		ga.repin.education.course02.topic02.hw.Hw02.main();
		Common.hwCaption("ООП — полиморфизм и интерфейсы (ч2)", true, 16832);
		ga.repin.education.course02.topic02_2.hw.Hw02_2.main();
		Common.hwCaption("2.3. Введение в Maven и Spring Boot", true, 16833);
		Common.hwCaption("2.4. Работа с исключениями", true, 16834);
		Common.hwCaption("2.5. Коллекции и сеты", true, 16835);
		appContext = SpringApplication.run(Application.class, args);
	}
}
