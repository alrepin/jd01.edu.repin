package ga.repin.education.course02.topic13.hw.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ga.repin.education.course02.topic13.hw.HwConstants.HW_ROOT_URL;
import static ga.repin.education.common.HtmlWrappers.*;

@Service
public class DepartmentsServiceV5Impl implements DepartmentsServiceV5 {
    EmployeeServiceV5 employeeServiceV5;

    @Autowired
    public DepartmentsServiceV5Impl(EmployeeServiceV5 employeeServiceV5) {
        this.employeeServiceV5 = employeeServiceV5;
    }

    public String apiInfo() {


        return mainTheme(
                hrefPrep(HW_ROOT_URL + "employee", "Employee API Description") +
                        " | <u>" +
                        hrefPrep(HW_ROOT_URL + "departments", "Departments API Description") +
                        "</u> " + HR +

                        "A JSON interface is offered to manage departments via HTTP." + BR +
                        "API access is provided at the following URLs:" + BR +

                        "<ul type=\"square\">" +

                        "<li>" +
                        HW_ROOT_URL + "departments/max-salary?departmentId=&ltDepartment number&gt " + BR +
                        "to return the employee with the highest salary based on the department number;" +
                        "</li>" +  BR +
                        commentPrep("Test URLs:", 4) + BR +
                        hrefPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=1",
                                "[for first department]") + BR +
                        commentPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=1",
                                null) + BR +
                        hrefPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=2",
                                "[for second department]") + BR +
                        commentPrep(
                                HW_ROOT_URL +
                                        "departments/max-salary?departmentId=2",
                                null) + BR + BR +

                        "<li>" +
                        HW_ROOT_URL + "departments/min-salary?departmentId=&ltDepartment number&gt " + BR +
                        "to return employee with the minimum salary based on the department number;" +
                        "</li>" +  BR +
                        commentPrep("Test URLs:", 4) + BR +

                        hrefPrep(HW_ROOT_URL + "departments/min-salary?departmentId=1", "[for first department]") + BR +
                        commentPrep(HW_ROOT_URL + "departments/min-salary?departmentId=1", null) + BR +
                        hrefPrep(HW_ROOT_URL + "departments/min-salary?departmentId=2", "[for second department]") + BR +
                        commentPrep(HW_ROOT_URL + "departments/min-salary?departmentId=2",null) + BR + BR +

                        "<li>" +
                        HW_ROOT_URL + "departments/all?departmentId=&ltDepartment number&gt " + BR +
                        "to return all employees in the department;" +
                        "</li>" +  BR +
                        commentPrep("Test URLs:", 4) + BR +

                        hrefPrep(HW_ROOT_URL + "departments/all?departmentId=1", "[for first department]") + BR +
                        commentPrep(HW_ROOT_URL + "departments/all?departmentId=1",null) + BR +
                        hrefPrep(HW_ROOT_URL + "departments/all?departmentId=2", "[for second department]") + BR +
                        commentPrep(HW_ROOT_URL + "departments/all?departmentId=2", null) + BR + BR +

                        "<li>" +
                        HW_ROOT_URL + "departments/all " + BR +
                        "to return all employees group by department." + BR +
                        hrefPrep(HW_ROOT_URL + "departments/all", "[Display a list]") +

                        "</ul>"
        );
    }

    @Override
    public Employee employeeWithMaxSalary(Integer departmentId) {
//        employeeServiceV5.throwOnEmptyList();
        return employeeServiceV5.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee employeeWithMinSalary(Integer departmentId) {
//        employeeServiceV5.throwOnEmptyList();
        return employeeServiceV5.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeeByDepartment(Integer departmentId) {
//        employeeServiceV5.throwOnEmptyList();
        return employeeServiceV5.listEmployee().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeGroupByDepartment() {
//        employeeServiceV5.throwOnEmptyList();
        return employeeServiceV5.listEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
