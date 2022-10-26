package ga.repin.education.common;

import ga.repin.education.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static ga.repin.education.common.UsefulMethods.*;
import static ga.repin.education.common.HtmlWrappers.*;

@Service
@Scope("session")
public class WelcomeServiceImpl implements WelcomeService {


    @Override
    public String operationIndex() {

        return mainTheme(
                "Demo service selection: " + HR +
                        "<ul type=\"square\">" +

                        "<li>" +
                        hrefPrep("/calculator", "CALCULATOR TASK") + BR +
                        commentPrep(hwCaption("2.3. Introduction to Maven and Spring Boot", true, "16833", 16), null) + BR +
                        "</li><li>" +
                        hrefPrep("/auth", "CHECKING AUTH FIELDS TASK") + BR +
                        commentPrep(hwCaption("2.4. Working with exceptions", true, "16834", 17), null) + BR +
                        "</li><li>" +
                        hrefPrep("/employee", "V1 API EMPLOYEE DEV (interface List)") + BR +
                        commentPrep(hwCaption("2.5. Collections and sets", true, "16835", 18), null) + BR +
                        "</li><li>" +
                        hrefPrep("/v2/employee", "V2 API EMPLOYEE DEV (interface Map)") + BR +
                        commentPrep(hwCaption("2.7. Collections: variety of implementations", true, "16837", 20), null) + BR +
                        "</li><li>" +
                        hrefPrep("/v3/employee", "V3 API EMPLOYEE DEV (Stream API)") + BR +
                        commentPrep(hwCaption("2.8. Stream API and Optional", true, "16838", 21), null) + BR +
                        "</li><li>" +
                        hrefPrep("/v4/employee", "V4 API EMPLOYEE DEV (commons-lang3)") + BR +
                        commentPrep(hwCaption("2.10. Libraries", true, "16841", 22), null) + BR +
                        "</li><li>" +
                        hrefPrep(ga.repin.education.course02.topic11.hw.HwConstants.HW_ENDPOINT, "API SESSION SHOPPING CART") + BR +
                        commentPrep(hwCaption("2.11. Spring", true, "16842", 23), null) + BR +
                        "</li><li>" +
                        hrefPrep(ga.repin.education.course02.topic12.hw.HwConstants.HW_ENDPOINT, "CALCULATOR TASK (TEST AFTER REVISION)") + BR +
                        commentPrep(hwCaption("2.12. Unit-testing", true, "16843", 24), null) +
                        "</li><li>" +
                        hrefPrep("/v5/employee", "V5 API EMPLOYEE DEV (JUnit+Mockito)") + BR +
                        commentPrep(hwCaption("2.13. Spring & Mockito", true, "16844", 25), null) + BR +
                        "</li>"

        );
    }

    @Value("${session.kill-pass}")
    private String sessionKillPass;

    @Override
    public String stopSpring(String pass) {
        if (Objects.equals(getMd5(pass), sessionKillPass)) {
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
