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

@Service
public class IndexServiceImpl implements IndexService {
    
    
    @Override
    public String course1Index() {
        
        return mainTheme(
                coursesTabs(1) +
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
        
        );
    }
    
    @Override
    public String course2Index() {
        
        return mainTheme(
                coursesTabs(2) +
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
                        commentPrep(hwCaption("2.16. Fundamentals of Algorithms, part 3", true, "16847", 28), null) + BR +
                        commentPrep(hwCaption("Coursework", true, "", 29), null) + BR +
                        "<li>" +
                        hrefPrep("/exam", "QUESTIONS-ANSWERS API") + BR +
                        "</li>" +
                        "</ul>"
        
        );
    }
    
    @Override
    public String course3Index() {
        
        return mainTheme(
                coursesTabs(3) +
                        "<ul type=\"square\">" +
                        "<h3>Third course of study</h3>" +
                       
                        commentPrep(hwCaption("3.1. Introduction to web development. HTTP, REST Protocols", true, "16848", 30), null) + BR +
                        "<li>" +
                        hrefPrep(ga.repin.education.course03.topic01.hw.HwConstants.HW_ENDPOINT,
                                "RECIPES JSON CONVERTER") + BR + "</li>" +
                        "</li>" +
        
                        commentPrep(hwCaption("3.2. API Creation. SwaggerUI, Postman", true, "16849", 31), null) + BR +
                        "<li>" +
                        hrefPrep("/swagger-ui.html",
                                "SWAGGER-UI") + " | " +
                        hrefPrep("/openapi.json",
                                "OPENAPI JSON") +
                        BR +
                        "</li>" +
        
                        commentPrep(hwCaption("3.3. Introduction to databases", true, "16850", 32), null) + BR +
                        /*"<li>" +
                        hrefPrep("/" + ga.repin.education.course03.topic03.hw.HwConstants.HW_ENDPOINT,
                                "") + BR + "</li>" +
                        "</li>" +*/
        
                        commentPrep(hwCaption("3.4. Introduction to SQL", true, "16851", 33), null) + BR +
                        /*"<li>" +
                        hrefPrep("/" + ga.repin.education.course03.topic03.hw.HwConstants.HW_ENDPOINT,
                                "") + BR + "</li>" +
                        "</li>" +*/
        
        
                        commentPrep(hwCaption("3.5. Data streams. Working with files", true, "16852", 34), null) + BR +
        
                        commentPrep(hwCaption("3.6. Testing Web Applications with Spring Boot", true, "16853", 35), null) + BR +
                        
                        "</ul>"
        
        );
    }
    
    @Override
    public String course4Index() {
        
        return mainTheme(
                coursesTabs(4) +
                        "<ul type=\"square\">" +
                        "<h3>Fourth course of study</h3>" +
                        
                        commentPrep(hwCaption("4.1. Continuing our SQL experience", true, "25284", 36), null) + BR +
                        "<li>" +
                        hrefPrep("/swagger-ui.html",
                                "SWAGGER-UI") + " | " +
                        hrefPrep("/openapi.json",
                                "OPENAPI JSON") +
                        BR +
                        "</li>" +
                        commentPrep(hwCaption("4.2. Managing database schemas", true, "25285", 37), null) + BR +
                        "</ul>"
        
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
        return course4Index();
    }
    
}
