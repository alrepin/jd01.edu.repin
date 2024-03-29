package ga.repin.education.peripheral;

import ga.repin.education.Application;
import ga.repin.education.common.HtmlWrappers;
import ga.repin.education.course04.topic05.hw.v8school.entity.Student;
import ga.repin.education.course04.topic05.hw.v8school.repository.StudentRepository;
import ga.repin.education.course06.course_work.tbot.entity.NotificationTask;
import ga.repin.education.course06.course_work.tbot.repository.NotificationTaskRepository;
import liquibase.repackaged.org.apache.commons.collections4.map.ListOrderedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ga.repin.education.common.HtmlWrappers.*;
import static ga.repin.education.common.UsefulMethods.*;
import static ga.repin.education.peripheral.PeripheralConstants.MAIN_DOMAIN;
import static ga.repin.education.peripheral.PeripheralConstants.TEAM_DOMAIN;

@Service
public class PeripheralServiceImpl implements PeripheralService {
    private final NotificationTaskRepository notificationTaskRepository;
    
    private final StudentRepository studentRepository;
    
    private final Logger logger = LoggerFactory.getLogger(PeripheralService.class);
    
    public PeripheralServiceImpl(NotificationTaskRepository notificationTaskRepository, StudentRepository studentRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
        this.studentRepository = studentRepository;
    }
    
    @Override
    public String course1Index() {
        
        return mainTheme(
                coursesTabs(1) +
                        "<ul type=\"square\">" +
                        //"<h3>First course of study</h3>" +
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
                        //"<h3>Second course of study</h3>" +
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
                        //"<h3>Third course of study</h3>" +
                        
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
                        //"<h3>Fourth course of study</h3>" +
                        
                        commentPrep(hwCaption("4.1. Continuing our SQL experience", true, "25284", 36), null) + BR +
                        
                        commentPrep(hwCaption("4.2. Managing database schemas", true, "25285", 37), null) + BR +
                        
                        commentPrep(hwCaption("4.3. Migrations and indexes", true, "25286", 38), null) + BR +
                        
                        commentPrep(hwCaption("4.4. Logging and configuring in the app", true, "25287", 39), null) + BR +
                        
                        commentPrep(hwCaption("4.5. Parallel streams", true, "25288", 40), null) + BR +
                        
                        commentPrep(hwCaption("4.6. Multithreading", true, "25289", 41), null) + BR +
                        
                        
                        "</ul>"
        
        );
    }
    
    @Override
    public String course5Index() {
        
        return mainTheme(
                coursesTabs(5) +
                        "<ul type=\"square\">" +
                        //"<h3>Fifth course of study</h3>" +
                        
                        commentPrep(hwCaption("5.4. Practical task for a technical interview", true, "31707", 42), null) + BR +
                        "<li>" +
                        commentPrep("Intro about myself", null) + BR +
                        embedVideo("1_kJ6ECp") +
                        "</li>" +
        
                        "<li>" +
                        commentPrep("Video response to questions from the ticket", null) + BR +
                        embedVideo("_xXvZiBD") +
                        "</li>" +
        
                        "<li>" +
                        commentPrep("Screencast of the progress of solving the task (part 1)", null) + BR +
                        embedVideo("kgm9Nkf8") +
                        "</li>" +
        
                        "<li>" +
                        commentPrep("Screencast of the progress of solving the task (part 2)", null) + BR +
                        embedVideo("eCi4RVgI") +
                        "</li>" +
                        
                        "</ul>"
        
        );
    }
    
    @Override
    public String course6Index() {
        
        return mainTheme(
                coursesTabs(6) +
                        "<ul type=\"square\">" +
                        //"<h3>Sixth course of study</h3>" +
                        
                        commentPrep(hwCaption("Coursework 3 (Bot in Telegram)", true, "", 43), null) + BR +
                        "<li>" +
                        hrefPrep("https://t.me/demo_jd01_edu_repin_ga", "CUCKOO BOT (an auto-updated list of active notifications can be seen at the bottom of the current page)") +
                        BR +
                        "</li>" +
                        "<a href=\"https://t.me/demo_jd01_edu_repin_ga\"><img src=\"/school/student/3/avatar\" width=\"150\" \n" +
                        "   height=\"150\" border=\"0\" alt=\"Demo\"></a>" +
                        "" +
                        notificationListSnippet() +
                        
                        "</ul>"
        
        );
    }
    
    @Override
    public String course7Index() {
        return mainTheme(
                coursesTabs(7) +
                        "<ul type=\"square\">" +
                        //"<h3>Sixth course of study</h3>" +
                        
                        BR +
                        "<li>" +
                        hrefPrep(TEAM_DOMAIN, "TEAMWORKING") +
                        BR +
                        "</li>" +
                        "<a href=\"" + TEAM_DOMAIN + "\"><img src=\"" + MAIN_DOMAIN + "/school/student/6/avatar/preview\" width=\"50\" \n" +
                        "   height=\"50\" border=\"0\" alt=\"Demo\"></a>" +
                        
                        
                        "</ul>"
        
        );
    }
    
    @Override
    public String course8Index() {
        return mainTheme(
                coursesTabs(8) +
                        "<ul type=\"square\">" +
                        //"<h3>Preparation for a technical interview (ticket 3)</h3>" +
                        commentPrep(hwCaption("8.2. Preparation for a technical interview (ticket 3)", false, "43886", 44), null) + BR +
                        "<li>" +
                        commentPrep("Intro about myself", null) + BR +
                        embedVideo("1_kJ6ECp") +
                        "</li>" +
                        
                        "<li>" +
                        commentPrep("Video response to questions from the ticket", null) + BR +
                        embedVideo("tRIkS3Sy") +
                        "</li>" +
                        
                        "<li>" +
                        commentPrep("Screencast of the progress of solving the task", null) + BR +
                        embedVideo("acyW-g0n") +
                        "</li>" +
                        hrefPrep("https://github.com/alrepin/jd01.edu.repin/pull/44/files", "Github PR Link") + BR +
/*                        "<a href=\"http://heaven.ga\"><img src=\"http://heaven.ga/JD10%20HEAVEN-DEVS%20TEAM%2068be78968e424de5b8434d0910bb16ea/photo_2023-02-17_08-56-23.png\" width=\"150\" \n" +
                        "   height=\"150\" border=\"0\" alt=\"Demo\"></a>" +*/
                        "</ul>"
        
        );
    }
    
    @Override
    public String course9Index() {
        return mainTheme(
                coursesTabs(9) +
                "<ul type=\"square\">" +
                        //"<h3>Sixth course of study</h3>" +
                
                        BR +
                        "<li>" +
                        hrefPrep(TEAM_DOMAIN, "GRADUATE WORK") +
                        BR +
                        "</li>" +
                        "<a href=\"" + TEAM_DOMAIN + "\"><img src=\"" + MAIN_DOMAIN + "/school/student/6/avatar/preview\" width=\"50\" \n" +
                        "   height=\"50\" border=\"0\" alt=\"Demo\"></a>" +
                
                
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
        return course8Index();
    }
    
    @Value("${server.port}")
    private String serverPort;
    
    public String getServerPort() {
        return serverPort;
    }
    
    public String getServerPort(String description) {
        return mainTheme(
                description
                        + HR +
                        getServerPort());
    }
    
    public Map<String, String> task040504() {
        Map<String, String> rec = new ListOrderedMap<>();
        markTheTime(false);
        int value = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        double time = markTheTime(true);
        markTheTime(false);
        rec.put("value calculated with original code", Integer.toString(value));
        rec.put("original time", time + " ms");
        
        markTheTime(false);
        value = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, Integer::sum);
        time = markTheTime(true);
        rec.put("calculated value with optimized code", Integer.toString(value));
        rec.put("time with parallel stream", time + " ms");
        return rec;
    }
    
    public void task040601() {
        List<Student> studentList = studentRepository.findAll();
        logger.info("Original order: " + studentList);
        logger.info("Names order printed with sout in multithreading mode: ");
        new Thread(() -> {
            System.out.println(studentList.get(2).getName());
            System.out.println(studentList.get(3).getName());
        }).start();
        
        new Thread(() -> {
            System.out.println(studentList.get(4).getName());
            System.out.println(studentList.get(5).getName());
        }).start();
        
        System.out.println(studentList.get(0).getName());
        System.out.println(studentList.get(1).getName());
    }
    
    public void task040602() {
        List<Student> studentList = studentRepository.findAll();
        logger.info("Original order: " + studentList);
        logger.info("Names order printed with sout in multithreading synchronized mode: ");
        
        System.out.println(studentList.get(0).getName());
        System.out.println(studentList.get(1).getName());
        
        Thread t1 = new Thread(() -> {
            synchronized (studentList) {
                System.out.println(studentList.get(2).getName());
                System.out.println(studentList.get(3).getName());
            }
        });
        
        Thread t2 = new Thread(() -> {
            synchronized (studentList) {
                System.out.println(studentList.get(4).getName());
                System.out.println(studentList.get(5).getName());
            }
        });
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
    
    @Override
    public List<NotificationTask> notificationsList() {
        final List<NotificationTask> notificationTasks = notificationTaskRepository.findAll();
        
        return notificationTasks.stream()
                .sorted(Comparator.comparing(NotificationTask::getDateTime))
                .collect(Collectors.toList());
    }
}
