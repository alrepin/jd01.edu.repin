package ga.repin.education;

import ga.repin.education.creation.HtmlWrappers;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class WelcomeServiceImpl implements WelcomeService {


    public String operationIndex() {

        return mainTheme("Выбор демо-сервиса: "
                + "<hr><a href=\"/calculator\">2.3 КАЛЬКУЛЯТОР</a>"
                + "<br><a href=\"/auth\">2.4 АУТЕНТИФИКАЦИЯ</a>"
                + "<br><a href=\"/employee\">2.5 API EMPLOYEE DEV</a>"
                + "<br><a href=\"/v2/employee\">2.7 VERSION 2 API EMPLOYEE DEV</a>"
                + "<br>"
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
