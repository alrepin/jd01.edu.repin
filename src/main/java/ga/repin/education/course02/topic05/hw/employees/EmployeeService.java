package ga.repin.education.course02.topic05.hw.employees;

import java.util.List;

public interface EmployeeService {
    String apiInfo();
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> listEmployee();
}
