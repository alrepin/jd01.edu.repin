package ga.repin.education.course02.topic08.hw.employees;

import ga.repin.education.course02.topic08.hw.employees.exceptions.EmployeeAlreadyAddedException;
import ga.repin.education.course02.topic08.hw.employees.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ga.repin.education.creation.Common.*;
import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class EmployeeServiceV3Impl implements EmployeeServiceV3 {
    private Map<String, Employee> employees;

    public EmployeeServiceV3Impl() {
        this.employees = new HashMap<>();
    }

    public String apiInfo() {
        List<String> testEmployees = new ArrayList<>(List.of(
                transliterate(randomFI()),
                transliterate(randomFI()),
                transliterate(randomFI()),
                transliterate(randomFI()),
                transliterate(randomFI())
        ));
        List<String> testEmployeeParams = new ArrayList<>(List.of(
                "&department=1&salary=20000.00",
                "&department=1&salary=30000.00",
                "&department=1&salary=40000.00",
                "&department=2&salary=50000.00",
                "&department=2&salary=60000.00"
        ));

        String testAddEmployees = "";
        String testRmEmployees = "";
        String testFindEmployees = "";
        int i = 1;
        for (String testEmployee : testEmployees) {
            testAddEmployees = testAddEmployees +
                    "<a href=\"/v3/employee/add?" + testEmployee +
                    testEmployeeParams.get(i - 1) +
                    "\">[Append " + i + "]</a> <i>/v3/employee/add?" +
                    testEmployee + testEmployeeParams.get(i - 1) + "</i><br>";
            testRmEmployees = testRmEmployees +
                    "<a href=\"/v3/employee/remove?" + testEmployee +
                    "\">[Put away " + i + "]</a> <i>/v3/employee/remove?" + testEmployee + "</i><br>";
            testFindEmployees = testFindEmployees +
                    "<a href=\"/v3/employee/find?" + testEmployee +
                    "\">[Search " + i + "]</a> <i>/v3/employee/find?" + testEmployee + "</i><br>";
            i++;
        }

        return mainTheme(
                "<u><a href=\"/v3/employee\">Employee API Description</a></u>" +
                        " | <a href=\"/v3/departments\">Departments API Description</a><hr>" +
                        "A JSON interface is offered to manage employees via HTTP.<br>" +
                        "API access is provided at the following URLs:<br>" +
                        "<ul type=\"square\">" +
                        "<li>" +
                        "/v3/employee/add?firstName=&ltEmployee name&gt&lastName=&ltEmployee surname&gt " +
                        "<br>to add an employee to a list;" +
                        "</li><i>Test URLs:</i><br>" +
                        testAddEmployees +
                        "<br><li>/v3/employee/remove?firstName=&ltEmployee name&gt&lastName=&ltEmployee surname&gt " +
                        "<br>to remove an employee from the list;" +
                        "</li>" +
                        "<i>Test URLs:</i><br>" +
                        testRmEmployees +
                        "<br><li>" +
                        "/v3/employee/find?firstName=&ltEmployee name&gt&lastName=&ltEmployee surname&gt " +
                        "<br>to get information about an employee;" +
                        "</li>" +
                        "<i>Test URLs:</i><br>" +
                        testFindEmployees +
                        "<br><li>" +
                        "/v3/employee/list <br>for a list of employees." +
                        "<br><a href=\"/v3/employee/list\">[Display a list]</a>" +
                        "</li></ul>"
        );
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Double salary) {
        if (!(isFilled(firstName, lastName))) return null;
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (existsEmployee(employee))
            throw new EmployeeAlreadyAddedException("Coo-coo! Attempt to create a duplicate entry.");
        employees.put(employee.toString(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!(isFilled(firstName, lastName))) return null;
        Employee employee = new Employee(firstName, lastName);
        if (!existsEmployee(employee)) {
            throw new EmployeeNotFoundException("No one to remove - no such employee like "
                    + employee.getFirstName() + " " + employee.getLastName());
        }
        employee = getEmployee(employee);
        employees.remove(employee.toString());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!isFilled(firstName, lastName)) return null;
        Employee employee = new Employee(firstName, lastName);
        if (!existsEmployee(employee)) {
            throw new EmployeeNotFoundException("An employee with such data was not found");
        }
        return getEmployee(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        if (employees.isEmpty()) {
            /*return null;*/
            throw new EmployeeNotFoundException("There are no employees on the list.");
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

    /*@Override
    public void throwOnEmptyList() {
        if (listEmployee() == null) {
            throw new EmployeeNotFoundException("There are no employees on the list.");
        }
    }*/

}
