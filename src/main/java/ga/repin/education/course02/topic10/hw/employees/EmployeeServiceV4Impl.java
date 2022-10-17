package ga.repin.education.course02.topic10.hw.employees;

import static ga.repin.education.course02.topic10.hw.HwConstants.*;
import static ga.repin.education.creation.Common.*;
import static ga.repin.education.creation.HtmlWrappers.*;

import ga.repin.education.course02.topic10.hw.employees.exceptions.EmployeeAlreadyAddedException;
import ga.repin.education.course02.topic10.hw.employees.exceptions.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceV4Impl implements EmployeeServiceV4 {
    private Map<String, Employee> employees;

    public EmployeeServiceV4Impl() {
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
                    hrefPrep(HW_ROOT_URL + "employee/add?" +
                                    testEmployee + testEmployeeParams.get(i - 1),
                            "[Append " + i + "]") + BR +
                    commentPrep(HW_ROOT_URL + "employee/add?" +
                            testEmployee + testEmployeeParams.get(i - 1), null) + BR;
            testRmEmployees = testRmEmployees +
                    hrefPrep(HW_ROOT_URL + "employee/remove?" +
                                    testEmployee,
                            "[Put away " + i + "]") + BR +
                    commentPrep(HW_ROOT_URL + "employee/remove?" +
                            testEmployee, null) + BR;
            testFindEmployees = testFindEmployees +
                    hrefPrep(HW_ROOT_URL +
                                    "employee/find?" + testEmployee,
                            "[Search " + i + "]") + BR +
                    commentPrep(HW_ROOT_URL + "employee/find?" +
                            testEmployee, null) + BR;
            i++;
        }

        return mainTheme(
                "<u>" +
                        hrefPrep(HW_ROOT_URL + "employee", "Employee API Description") +
                        "</u>" +
                        " | " +
                        hrefPrep(HW_ROOT_URL + "departments", "Departments API Description") + HR +

                        "A JSON interface is offered to manage employees via HTTP." + BR +
                        "API access is provided at the following URLs:" + BR +
                        commentPrep("You can try to edit the key parameters in the text edits, then " +
                                " put it to the address bar, then ENTER and see " +
                                "the correct behavior of the program.", 3) + BR +

                        "<ul type=\"square\">" +

                        "<li>" +
                        HW_ROOT_URL +
                        "employee/add?firstName=&ltEmployee name&gt&lastName=&ltEmployee surname&gt " + BR +
                        "to add an employee to a list;" +
                        "</li>" + BR +
                        commentPrep("Test URLs:", 4) + BR +
                        testAddEmployees + BR +

                        "<li>" +
                        HW_ROOT_URL +
                        "employee/remove?firstName=&ltEmployee name&gt&lastName=&ltEmployee surname&gt " + BR +
                        "to remove an employee from the list;" +
                        "</li>" +  BR +
                        commentPrep("Test URLs:", 4) + BR +
                        testRmEmployees + BR +

                        "<li>" +
                        HW_ROOT_URL +
                        "employee/find?firstName=&ltEmployee name&gt&lastName=&ltEmployee surname&gt " + BR +
                        "to get information about an employee;" +
                        "</li>" +  BR +
                        commentPrep("Test URLs:", 4) + BR +
                        testFindEmployees + BR +

                        "<li>" +
                        HW_ROOT_URL +
                        "employee/list " + BR + "for a list of employees." + BR +
                        hrefPrep(HW_ROOT_URL + "employee/list", "[Display a list]") +
                        "</li>" +
                        "</ul>"
        );
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Double salary) {
        if (!(isUnicodeFilled(firstName, lastName))) return null;
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (existsEmployee(employee))
            throw new EmployeeAlreadyAddedException("Coo-coo! Attempt to create a duplicate entry.");
        employees.put(employee.toString(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!(isUnicodeFilled(firstName, lastName))) return null;
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
        if (!isUnicodeFilled(firstName, lastName)) return null;
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
