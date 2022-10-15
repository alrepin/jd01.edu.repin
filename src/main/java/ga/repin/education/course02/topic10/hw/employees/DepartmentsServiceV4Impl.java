package ga.repin.education.course02.topic10.hw.employees;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ga.repin.education.creation.HtmlWrappers.*;
import static ga.repin.education.course02.topic10.hw.HwConstants.*;

@Service
public class DepartmentsServiceV4Impl implements DepartmentsServiceV4 {
    EmployeeServiceV4 employeeServiceV4;

    public DepartmentsServiceV4Impl(EmployeeServiceV4 employeeServiceV4) {
        this.employeeServiceV4 = employeeServiceV4;
    }

    public String apiInfo() {


        return mainTheme(
                hrefPrep(HW_ROOT_URL +
                        "employee", "Employee API Description") +
                        " | <u>" +
                        hrefPrep(HW_ROOT_URL +
                                "departments", "Departments API Description") +
                        "</u><hr>" +
                        "A JSON interface is offered to manage departments via HTTP.<br>" +
                        "API access is provided at the following URLs:<br>" +
                        "<ul type=\"square\">" +

                        "<li>" +
                        HW_ROOT_URL +
                        "departments/max-salary?departmentId=&ltDepartment number&gt " +
                        "<br>to return the employee with the highest salary based on the department number;" +
                        "</li>" +
                        commentPrep("Test URLs:", 4) +
                        hrefPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=1",
                                "[for first department]") +
                        commentPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=1",
                                null) +
                        hrefPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=2",
                                "[for second department]") +
                        commentPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=2",
                                null) +

                        "<br><li>" +
                        HW_ROOT_URL +
                        "departments/min-salary?departmentId=&ltDepartment number&gt " +
                        "<br>to return employee with the minimum salary based on the department number;" +
                        "</li>" +
                        commentPrep("Test URLs:", 4) +

                        "<a href=\"" +
                        HW_ROOT_URL +
                        "departments/min-salary?departmentId=1" +
                        "\">[for first department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">" +
                        HW_ROOT_URL +
                        "departments/min-salary?departmentId=1" +
                        "</font></i><br>" +
                        "<a href=\"" +
                        HW_ROOT_URL +
                        "departments/min-salary?departmentId=2" +
                        "\">[for second department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">" +
                        HW_ROOT_URL +
                        "departments/min-salary?departmentId=2" +
                        "</font></i><br>" +

                        "<br><li>" +
                        HW_ROOT_URL +
                        "departments/all?departmentId=&ltDepartment number&gt " +
                        "<br>to return all employees in the department;" +
                        "</li>" +
                        commentPrep("Test URLs:", 4) +

                        "<a href=\"" +
                        HW_ROOT_URL +
                        "departments/all?departmentId=1" +
                        "\">[for first department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">" +
                        HW_ROOT_URL +
                        "departments/all?departmentId=1" +
                        "</font></i><br>" +
                        "<a href=\"" +
                        HW_ROOT_URL +
                        "departments/all?departmentId=2" +
                        "\">[for second department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">" +
                        HW_ROOT_URL +
                        "departments/all?departmentId=2" +
                        "</font></i><br>" +

                        "<br><li>" +
                        HW_ROOT_URL +
                        "departments/all " +
                        "<br>to return all employees group by department." +
                        "<a href=\"" +
                        HW_ROOT_URL +
                        "departments/all" +
                        "\"><br>[Display a list]</a>" +

                        "</ul>"
        );
    }

    @Override
    public Employee employeeWithMaxSalary(Integer departmentId) {
//        employeeServiceV4.throwOnEmptyList();
        return employeeServiceV4.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee employeeWithMinSalary(Integer departmentId) {
//        employeeServiceV4.throwOnEmptyList();
        return employeeServiceV4.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeeByDepartment(Integer departmentId) {
//        employeeServiceV4.throwOnEmptyList();
        return employeeServiceV4.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeGroupByDepartment() {
//        employeeServiceV4.throwOnEmptyList();
        return employeeServiceV4.listEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
