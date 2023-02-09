package ga.repin.education;

import ga.repin.education.common.UsefulMethods;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "School API",
                version = "0.0.1",
                description = "The client-server API provides a " +
                        "simple lightweight school openapi including " +
                        "CRUD operations with student and faculty models.",
                license = @License(
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html",
                        name = "Apache 2.0"
                ),
                contact = @Contact(
                        name = "alrepin",
                        email = "a@repin.ga",
                        url = "repin.ga"
                )
        ),
        servers = {
/*                @Server(
                        description = "(with LetsEncrypt cert.)",
                        url = "https://repin.ga"),
                @Server(
                        description = "(just HTTP only, no ssl)",
                        url = "http://repin.ga"),*/
                @Server(
                        description = "(local)",
                        url = "/"),
        }
)

public class Application {
    public static ApplicationContext appContext = null;
    
    public static void main(String[] args) {
        UsefulMethods.hwCaption("Установка инструментов разработчика", true, 16819);
        ga.repin.education.course01.topic01.hw.Hw01.main();
        UsefulMethods.hwCaption("Переменные", true, 16820);
        ga.repin.education.course01.topic02.hw.Hw02.main();
        UsefulMethods.hwCaption("Условные операторы", true, 16821);
        ga.repin.education.course01.topic03.hw.Hw03.main();
        UsefulMethods.hwCaption("Циклы", true, 16822);
        ga.repin.education.course01.topic04.hw.Hw04.main();
        UsefulMethods.hwCaption("Массивы", true, 16823);
        ga.repin.education.course01.topic05.hw.Hw05.main();
        UsefulMethods.hwCaption("Массивы ч.2", true, 16824);
        ga.repin.education.course01.topic06.hw.Hw06.main();
        UsefulMethods.hwCaption("Строки", true, 16825);
        ga.repin.education.course01.topic07.hw.Hw07.main();
        UsefulMethods.hwCaption("Методы", true, 16826);
        ga.repin.education.course01.topic08.hw.Hw08.main();
        UsefulMethods.hwCaption("Объекты и классы", true, 16827);
        ga.repin.education.course01.topic09.hw.Hw09.main();
        UsefulMethods.hwCaption("Методы объектов", true, 16828);
        ga.repin.education.course01.topic10.hw.Hw10.main();
        ga.repin.education.course01.course_work.Cw01.main();
        UsefulMethods.hwCaption("ООП — инкапсуляция и наследование ч. 1", true, 16831);
        ga.repin.education.course02.topic02.hw.Hw02.main();
        UsefulMethods.hwCaption("ООП — полиморфизм и интерфейсы (ч2)", true, 16832);
        ga.repin.education.course02.topic02_2.hw.Hw02_2.main();
        //UsefulMethods.hwCaption("2.3. Введение в Maven и Spring Boot", true, 16833);
        //UsefulMethods.hwCaption("2.4. Работа с исключениями", true, 16834);
        //UsefulMethods.hwCaption("2.5. Коллекции и сеты", true, 16835);
        UsefulMethods.hwCaption("2.6. Коллекции: сеты и мапы", true, 16836);
        ga.repin.education.course02.topic06.hw.Hw06.main();
        //UsefulMethods.hwCaption("2.7. Коллекции: многообразие реализаций", true, 16837);
        //UsefulMethods.hwCaption("2.8. Stream API и Optional", true, 16838);
        //UsefulMethods.hwCaption("2.10. Библиотеки", false, 16841);
        appContext = SpringApplication.run(Application.class, args);
    }
}
