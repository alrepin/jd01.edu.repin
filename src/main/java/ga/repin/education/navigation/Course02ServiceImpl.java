package ga.repin.education.navigation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static ga.repin.education.common.HtmlWrappers.*;
import static ga.repin.education.common.UsefulMethods.hwCaption;
import static ga.repin.education.navigation.NavigationConstants.*;

@Service
public class Course02ServiceImpl implements Course02Service {


    @Override
    public String operationIndex() {

        return mainTheme(
                hrefPrep(ROOT_URL_01, "First course") +
                        " | " +
                        "<u>" +
                        hrefPrep(ROOT_URL_02, "Second course") + HR +
                        "</u>" +
                        "The presented tasks were solved as a part of the educational process: " + BR +
                        "<ul type=\"square\">" +
                        "<h3>Second course of study</h3>" +
                        commentPrep(hwCaption("2.2.1. OOP - Encapsulation and Inheritance", true, "16831", 14), null) + BR +
                        commentPrep(hwCaption("2.2.2. OOP - Interfaces and polymorphism", true, "16832", 15), null) + BR +
                        commentPrep(hwCaption("2.3. Introduction to Maven and Spring Boot", true, "16833", 16), null) + BR +
                        "<li>" +
                        hrefPrep("/calculator", "CALCULATOR TASK") + BR + "</li>" +
                        commentPrep(hwCaption("2.4. Working with exceptions", true, "16834", 17), null) + BR +
                        "<li>" +
                        hrefPrep("/auth", "CHECKING AUTH FIELDS TASK") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.5. Collections and sets", true, "16835", 18), null) + BR +
                        "<li>" +
                        hrefPrep("/employee", "V1 API EMPLOYEE DEV (interface List)") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.6. Collections: Sets & Maps", true, "16836", 19), null) + BR +
                        "<li>" +
                        hrefPrep("/v2/employee", "V2 API EMPLOYEE DEV (interface Map)") + BR +
                        commentPrep(hwCaption("2.7. Collections: variety of implementations", true, "16837", 20), null) + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.8. Stream API and Optional", true, "16838", 21), null) + BR +
                        "<li>" +
                        hrefPrep("/v3/employee", "V3 API EMPLOYEE DEV (Stream API)") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.10. Libraries", true, "16841", 22), null) + BR +
                        "<li>" +
                        hrefPrep("/v4/employee", "V4 API EMPLOYEE DEV (commons-lang3)") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.11. Spring", true, "16842", 23), null) + BR +
                        "<li>" +
                        hrefPrep(ga.repin.education.course02.topic11.hw.HwConstants.HW_ENDPOINT, "API SESSION SHOPPING CART") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.12. Unit-testing", true, "16843", 24), null) +
                        "<li>" +
                        hrefPrep(ga.repin.education.course02.topic12.hw.HwConstants.HW_ENDPOINT, "CALCULATOR TASK (TEST AFTER REVISION)") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.13. Spring & Mockito", true, "16844", 25), null) + BR +
                        "<li>" +
                        hrefPrep("/v5/employee", "V5 API EMPLOYEE DEV (JUnit+Mockito)") + BR +
                        "</li>" +
                        commentPrep(hwCaption("2.14. Fundamentals of Algorithms, part 1", true, "16845", 26), null) + BR +
                        commentPrep(hwCaption("2.15. Fundamentals of Algorithms, part 2", true, "16846", 27), null) + BR +
                        commentPrep(hwCaption("2.16. Fundamentals of Algorithms, part 3", false, "16847", 28), null) + BR +
                        "</ul>"

        );
    }

    @Value("${session.kill-pass}")
    private String sessionKillPass;

}
