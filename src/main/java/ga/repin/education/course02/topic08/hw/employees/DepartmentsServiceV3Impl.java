package ga.repin.education.course02.topic08.hw.employees;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static ga.repin.education.common.HtmlWrappers.mainTheme;

@Service
public class DepartmentsServiceV3Impl implements DepartmentsServiceV3 {
    EmployeeServiceV3 employeeServiceV3;

    public DepartmentsServiceV3Impl(EmployeeServiceV3 employeeServiceV3) {
        this.employeeServiceV3 = employeeServiceV3;
    }

    public String apiInfo() {


        return mainTheme(
                "<a href=\"/v3/employee\">Employee API Description</a>" +
                        " | <u><a href=\"/v3/departments\">Departments API Description</a></u><hr>" +
                        "A JSON interface is offered to manage departments via HTTP.<br>" +
                        "API access is provided at the following URLs:<br>" +
                        "<ul type=\"square\">" +

                        "<li>" +
                        "/v3/departments/max-salary?departmentId=&ltDepartment number&gt " +
                        "<br>to return the employee with the highest salary based on the department number;" +
                        "</li><i>Test URLs:</i><br>" +

                        "<a href=\"/v3/departments/max-salary?departmentId=1" +
                        "\">[for first department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">/v3/departments/max-salary?departmentId=1" +
                        "</font></i><br>" +
                        "<a href=\"/v3/departments/max-salary?departmentId=2" +
                        "\">[for second department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">/v3/departments/max-salary?departmentId=2" +
                        "</font></i><br>" +

                        "<br><li>" +
                        "/v3/departments/min-salary?departmentId=&ltDepartment number&gt " +
                        "<br>to return employee with the minimum salary based on the department number;" +
                        "</li><i>Test URLs:</i><br>" +

                        "<a href=\"/v3/departments/min-salary?departmentId=1" +
                        "\">[for first department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">/v3/departments/min-salary?departmentId=1" +
                        "</font></i><br>" +
                        "<a href=\"/v3/departments/min-salary?departmentId=2" +
                        "\">[for second department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">/v3/departments/min-salary?departmentId=2" +
                        "</font></i><br>" +

                        "<br><li>" +
                        "/v3/departments/all?departmentId=&ltDepartment number&gt " +
                        "<br>to return all employees in the department;" +
                        "</li><i>Test URLs:</i><br>" +

                        "<a href=\"/v3/departments/all?departmentId=1" +
                        "\">[for first department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">/v3/departments/all?departmentId=1" +
                        "</font></i><br>" +
                        "<a href=\"/v3/departments/all?departmentId=2" +
                        "\">[for second department]</a> " +
                        "<i><font face=\"Times New Roman\" size=\"3\">/v3/departments/all?departmentId=2" +
                        "</font></i><br>" +

                        "<br><li>" +
                        "/v3/departments/all " +
                        "<br>to return all employees group by department." +
                        "<a href=\"/v3/departments/all" +
                        "\"><br>[Display a list]</a>" +

                        "</ul>"
        );
    }

    @Override
    public Employee employeeWithMaxSalary(Integer departmentId) {
//        employeeServiceV3.throwOnEmptyList();
        return employeeServiceV3.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee employeeWithMinSalary(Integer departmentId) {
//        employeeServiceV3.throwOnEmptyList();
        return employeeServiceV3.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeeByDepartment(Integer departmentId) {
//        employeeServiceV3.throwOnEmptyList();
        return employeeServiceV3.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeGroupByDepartment() {
//        employeeServiceV3.throwOnEmptyList();
        return employeeServiceV3.listEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
