package ga.repin.education.course02.topic13.hw.employees;

import java.util.List;

public interface EmployeeServiceV5 {
    String apiInfo();

    Employee addEmployee(String firstName, String lastName, Integer department, Double salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> listEmployee();

    boolean existsEmployee(Employee employee);
}
