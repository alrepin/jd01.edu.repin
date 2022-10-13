package ga.repin.education;

import ga.repin.education.creation.Common;
import ga.repin.education.creation.HtmlWrappers;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import static ga.repin.education.creation.Common.hwCaption;
import static ga.repin.education.creation.HtmlWrappers.commentPrep;
import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    @Override
    public String operationIndex() {

        return mainTheme("Demo service selection: "
                + "<hr><a href=\"/calculator\">2.3 CALCULATOR TASK</a>"
                + commentPrep(hwCaption("2.3. Introduction to Maven and Spring Boot", true, "16833"), null)
                + "<a href=\"/auth\">2.4 CHECKING AUTH FIELDS TASK</a>"
                + commentPrep(hwCaption("2.4. Working with exceptions", true, "16834"), null)
                + "<a href=\"/employee\">2.5 V1 API EMPLOYEE DEV (interface List)</a>"
                + commentPrep(hwCaption("2.5. Collections and sets", true, "16835"), null)
                + "<a href=\"/v2/employee\">2.7 V2 API EMPLOYEE DEV (interface Map)</a>"
                + commentPrep(hwCaption("2.7. Collections: variety of implementations", true, "16837"), null)
                + "<a href=\"/v3/employee\">2.8 V3 API EMPLOYEE DEV (Stream API)</a>"
                + commentPrep(hwCaption("2.8. Stream API and Optional", true, "16838"), null)
                + "<a href=\"/v4/employee\">2.10 V4 API EMPLOYEE DEV (commons-lang3)</a>"
                + commentPrep(hwCaption("2.10. Libraries", false, "16841"), null)
        );
    }

    @Override
    public String stopSpring(String pass) {
        if (pass.equals("")) {
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
