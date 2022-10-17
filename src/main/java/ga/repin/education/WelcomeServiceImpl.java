package ga.repin.education;

import ga.repin.education.creation.HtmlWrappers;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static ga.repin.education.creation.Common.*;
import static ga.repin.education.creation.HtmlWrappers.*;

@Service
@Scope("session")
public class WelcomeServiceImpl implements WelcomeService {


    @Override
    public String operationIndex() {

        return mainTheme(
                "Demo service selection: " + HR +
                hrefPrep("/calculator","2.3 CALCULATOR TASK") + BR +
                commentPrep(hwCaption("2.3. Introduction to Maven and Spring Boot",true, "16833", 16), null) + BR +
                hrefPrep("/auth","2.4 CHECKING AUTH FIELDS TASK") + BR +
                commentPrep(hwCaption("2.4. Working with exceptions", true, "16834", 17), null) + BR +
                hrefPrep("/employee", "2.5 V1 API EMPLOYEE DEV (interface List)") + BR +
                commentPrep(hwCaption("2.5. Collections and sets", true, "16835", 18), null) + BR +
                hrefPrep("/v2/employee","2.7 V2 API EMPLOYEE DEV (interface Map)") + BR +
                commentPrep(hwCaption("2.7. Collections: variety of implementations", true, "16837", 20), null) + BR +
                hrefPrep("/v3/employee","2.8 V3 API EMPLOYEE DEV (Stream API)") + BR +
                commentPrep(hwCaption("2.8. Stream API and Optional", true, "16838", 21), null) + BR +
                hrefPrep("/v4/employee", "2.10 V4 API EMPLOYEE DEV (commons-lang3)") + BR +
                commentPrep(hwCaption("2.10. Libraries", true, "16841", 22), null) + BR +
                hrefPrep(ga.repin.education.course02.topic11.hw.HwConstants.HW_ENDPOINT,"2.11 API SESSION SHOPPING CART") + BR +
                commentPrep(hwCaption("2.11. Spring",true, "16842", 23), null)
        );
    }

    @Override
    public String stopSpring(String pass) {
        if (pass.equals(ga.repin.education.creation.NoCommitConstants.PASS)) {
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
