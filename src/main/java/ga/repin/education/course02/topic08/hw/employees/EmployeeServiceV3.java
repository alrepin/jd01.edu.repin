package ga.repin.education.course02.topic08.hw.employees;

import java.util.List;

public interface EmployeeServiceV3 {
    String apiInfo();

    Employee addEmployee(String firstName, String lastName, Integer department, Double salary);

    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> listEmployee();

}
