package ga.repin.education.course02.topic07.hw.employees;

import ga.repin.education.course02.topic07.hw.employees.exceptions.EmployeeAlreadyAddedException;
import ga.repin.education.course02.topic07.hw.employees.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static ga.repin.education.creation.Common.isFilled;
import static ga.repin.education.creation.Common.randomFI;
import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class EmployeeServiceV2Impl implements EmployeeServiceV2 {
    private Map<String, Employee> employees;

    public EmployeeServiceV2Impl() {
        this.employees = new HashMap<>();
    }

    public String apiInfo() {
    List<String> testEmployees = new ArrayList<>(List.of(randomFI(), randomFI(), randomFI(),
            randomFI(), randomFI()));
        String testAddEmployees = "";
        String testRmEmployees = "";
        String testFindEmployees = "";
        int i = 1;
        for (String testEmployee : testEmployees) {
            testAddEmployees = testAddEmployees +
                    "<a href=\"/v2/employee/add?" + testEmployee +
                    "\">[Добавить " + i + "-го]</a> - /v2/employee/add?" + testEmployee + "<br>";
            testRmEmployees = testRmEmployees +
                    "<a href=\"/v2/employee/remove?" + testEmployee +
                    "\">[Убрать " + i + "-го]</a> - /v2/employee/remove?" + testEmployee + "<br>";
            testFindEmployees = testFindEmployees +
                    "<a href=\"/v2/employee/find?" + testEmployee +
                    "\">[Найти " + i + "-го]</a> - /v2/employee/find?" + testEmployee + "<br>";
            i++;
        }

        return mainTheme(
                "Описание API<hr>" +
                        "Для управления сотрудниками по HTTP предлагается JSON-интерфейс.<br>" +
                        "Доступ к API предоставляется по следующим URL:<br>" +
                        "<ul type=\"square\">\n" +
                        "<li>" +
                        "/v2/employee/add?firstName=<Имя>&lastName=<Фамилия> для добавления сотрудника в лист;" +
                        "</li>Тестовые URL:<br>" +
                        testAddEmployees +
                        "<li>/v2/employee/remove?firstName=<Имя>&lastName=<Фамилия> для удаления сотрудника из листа;" +
                        "</li>" +
                        "</li>Тестовые URL:<br>" +
                        testRmEmployees +
                        "<li>" +
                        "/v2/employee/find?firstName=<Имя>&lastName=<Фамилия> для получения данных о сотруднике;" +
                        "</li>" +
                        "</li>Тестовые URL:<br>" +
                        testFindEmployees +
                        "<li>" +
                        "/v2/employee/list для получения списка сотрудников." +
                        "<br><a href=\"/v2/employee/list\">[Вывести список]</a>" +
                        "</li></ul>"
        );
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (!(isFilled(firstName, lastName))) return null;
        Employee employee = new Employee(firstName, lastName);
        if (existsEmployee(employee))
            throw new EmployeeAlreadyAddedException("Ку-ку! Попытка создания дублирующей записи.");
        employees.put(employee.toString(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (!(isFilled(firstName, lastName))) return null;
        Employee employee = new Employee(firstName, lastName);
        if (!existsEmployee(employee)) {
            throw new EmployeeNotFoundException("Некого удалять - нет такого сотрудника!");
        }
        employees.remove(employee.toString());
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (!isFilled(firstName, lastName)) return null;
        Employee employee = new Employee(firstName, lastName);
        if (!existsEmployee(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
        }
        return employee;
    }

    public List<Employee> listEmployee() {
        if (employees.isEmpty()) {
            return null;
        }
        List<Employee> employeeList = new ArrayList<Employee>(employees.values());
        return employeeList;
    }

    public boolean existsEmployee(Employee employee) {
        return (getEmployee(employee) != null);
    }

    private Employee getEmployee(Employee employee) {
        if (!employees.containsKey(employee.toString())) {
            return null;
        }
        return employees.get(employee.toString());
    }

}
