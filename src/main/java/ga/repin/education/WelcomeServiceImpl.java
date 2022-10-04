package ga.repin.education;

import ga.repin.education.creation.HtmlWrappers;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    @Override
    public String operationIndex() {

        return mainTheme("Demo service selection: "
                + "<hr><a href=\"/calculator\">2.3 CALCULATOR TASK</a>"
                + "<br><a href=\"/auth\">2.4 CHECKING AUTH FIELDS TASK</a>"
                + "<br><a href=\"/employee\">2.5 V1 API EMPLOYEE DEV (interface List)</a>"
                + "<br><a href=\"/v2/employee\">2.7 V2 API EMPLOYEE DEV (interface Map)</a>"
                + "<br><a href=\"/v3/employee\">2.8 V3 API EMPLOYEE DEV (Stream API)</a>"
                + "<br>"
        );
    }

    @Override
    public String stopSpring(String pass) {
        if (pass.equals("killit")) {
            SpringApplication.exit(Application.appContext);
        }
        return mainTheme("У вас нет таких привилегий");
    }

    @Override
    public String letSwitchTheme() {
        HtmlWrappers.nightTheme = !HtmlWrappers.nightTheme;
        return operationIndex();
    }

}
