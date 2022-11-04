package ga.repin.education.navigation;

import ga.repin.education.Application;
import ga.repin.education.common.HtmlWrappers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static ga.repin.education.common.HtmlWrappers.*;
import static ga.repin.education.common.UsefulMethods.getMd5;
import static ga.repin.education.common.UsefulMethods.hwCaption;
import static ga.repin.education.navigation.NavigationConstants.*;

@Service
public class Course01ServiceImpl implements Course01Service {


    @Override
    public String operationIndex() {

        return mainTheme(
                "<u>" +
                        hrefPrep(ROOT_URL_01, "First course") +
                        "</u>" +
                        " | " +
                        hrefPrep(ROOT_URL_02, "Second course") + HR +
                        "The presented tasks were solved as a part of the educational process: " + BR +
                        "<ul type=\"square\">" +
                        "<h3>First course of study</h3>" +
                        commentPrep(hwCaption("1.1. Installing developer tools", true, "16819", 1), null) + BR +
                        commentPrep(hwCaption("1.2. Variables", true, "16820", 2), null) + BR +
                        commentPrep(hwCaption("1.3. Conditional statements", true, "16821", 3), null) + BR +
                        commentPrep(hwCaption("1.4. Cycles", true, "16822", 5), null) + BR +
                        commentPrep(hwCaption("1.5. Arrays ch.1", true, "16823", 6), null) + BR +
                        commentPrep(hwCaption("1.6. Arrays ch.2", true, "16824", 7), null) + BR +
                        commentPrep(hwCaption("1.7. Strings", true, "16825", 8), null) + BR +
                        commentPrep(hwCaption("1.8. Methods", true, "16826", 9), null) + BR +
                        commentPrep(hwCaption("1.9. Objects and classes", true, "16827", 10), null) + BR +
                        commentPrep(hwCaption("1.10. Object Methods", true, "16828", 11), null) + BR +
                        commentPrep(hwCaption("Coursework", true, "", 12), null) + BR +
                        "</ul>"
                        /*"<li>" +
                        hrefPrep("/calculator", "CALCULATOR TASK") + BR + "</li>" +
                        commentPrep(hwCaption("2.4. Working with exceptions", true, "16834", 17), null) + BR +
                        "<li>" + BR*/


        );
    }

    @Value("${session.kill-pass}")
    private String sessionKillPass;

    @Override
    public String stopSpring(String pass) {
        if (Objects.equals(getMd5(pass), sessionKillPass)) {
            SpringApplication.exit(Application.appContext);
        }
        return mainTheme("You do not have such privileges");
    }

    @Override
    public String letSwitchTheme() {
        HtmlWrappers.nightTheme = !HtmlWrappers.nightTheme;
        return operationIndex();
    }

}
