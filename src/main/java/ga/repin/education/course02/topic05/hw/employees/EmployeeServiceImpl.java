package ga.repin.education.course02.topic05.hw.employees;

import ga.repin.education.course02.topic05.hw.employees.exceptions.EmployeeAlreadyAddedException;
import ga.repin.education.course02.topic05.hw.employees.exceptions.EmployeeNotFoundException;
import ga.repin.education.creation.Common;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.creation.Common.*;
import static ga.repin.education.creation.HtmlWrappers.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //private static Employee[] employees;
    private List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    public String apiInfo() {
        String testEmployees[] = {randomFI(), randomFI(), randomFI(),
                randomFI(), randomFI()};
        String testAddEmployees = "";
        String testRmEmployees = "";
        String testFindEmployees = "";
        for (int i = 0; i < testEmployees.length; i++) {
            testAddEmployees = testAddEmployees +
                    "<a href=\"/employee/add?" + testEmployees[i] +
                    "\">[Добавить " + (i + 1) + "-го]</a> - /employee/add?" + testEmployees[i] + "<br>";
            testRmEmployees = testRmEmployees +
                    "<a href=\"/employee/remove?" + testEmployees[i] +
                    "\">[Убрать " + (i + 1) + "-го]</a> - /employee/remove?" + testEmployees[i] + "<br>";
            testFindEmployees = testFindEmployees +
                    "<a href=\"/employee/find?" + testEmployees[i] +
                    "\">[Найти " + (i + 1) + "-го]</a> - /employee/find?" + testEmployees[i] + "<br>";
        }
        return mainTheme(
                "Описание API<hr>" +
                        "Для управления сотрудниками по HTTP предлагается JSON-интерфейс.<br>" +
                        "Доступ к API предоставляется по следующим URL:<br>" +
                        "<ul type=\"square\">\n" +
                        "<li>" +
                        "/employee/add?firstName=<Имя>&lastName=<Фамилия> для добавления сотрудника в лист;" +
                        "</li>Тестовые URL:<br>" +
                        testAddEmployees +
                        "<li>/employee/remove?firstName=<Имя>&lastName=<Фамилия> для удаления сотрудника из листа;" +
                        "</li>" +
                        "</li>Тестовые URL:<br>" +
                        testRmEmployees +
                        "<li>" +
                        "/employee/find?firstName=<Имя>&lastName=<Фамилия> для получения данных о сотруднике;" +
                        "</li>" +
                        "</li>Тестовые URL:<br>" +
                        testFindEmployees +
                        "<li>" +
                        "/employee/list для получения списка сотрудников." +
                        "<br><a href=\"/employee/list\">[Вывести список]</a>" +
                        "</li></ul>"
        );
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (!(Common.isUnicodeFilled(firstName, lastName))) return null;
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee))
            throw new EmployeeAlreadyAddedException("Попытка создания дублирующей записи");
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (!(Common.isUnicodeFilled(firstName, lastName))) return null;
        Employee employee = new Employee(firstName, lastName);
        if (existsEmployee(firstName, lastName)) {
            employees.remove(employee);
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (!Common.isUnicodeFilled(firstName, lastName)) return null;
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee))
            throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
        return employee;
    }

    public List<Employee> listEmployee() {
        if (employees.isEmpty()) {
            return null;
        }
        return employees;
    }

    public boolean existsEmployee(String firstName, String lastName) {
        return (findEmployee(firstName, lastName) != null);
    }

}
