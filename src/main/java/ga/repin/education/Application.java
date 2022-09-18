package ga.repin.education;

import ga.repin.education.creation.Common;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Common.hwCaption("2.4. Работа с исключениями", false, 16834);
        SpringApplication.run(Application.class, args);

    }
}
