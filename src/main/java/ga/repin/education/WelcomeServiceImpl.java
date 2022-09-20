package ga.repin.education;

import ga.repin.education.creation.HtmlWrappers;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class WelcomeServiceImpl implements WelcomeService {


    public String operationIndex() {

        return mainTheme("Выбор сервиса: "
                + "<hr><a href=\"/auth\">[АУТЕНТИФИКАЦИЯ]</a>"
                + "<br><a href=\"/calculator\">[КАЛЬКУЛЯТОР]</a>"
                + "<br><a href=\"/employee\">[API EMPLOYEE DEV]</a>"
                + "<br><a href=\"/exit?pass=\">[УБИТЬ СЕРВИС]</a>"
        );
    }

    public String stopSpring(String pass) {
        if (pass.equals("killit")) {
            SpringApplication.exit(Application.appContext);
        }
        return mainTheme("У вас нет таких привилегий");
    }

    public String letSwitchTheme() {
        HtmlWrappers.nightTheme=!HtmlWrappers.nightTheme;
        return operationIndex();
    }

}
