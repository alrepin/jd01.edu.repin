package ga.repin.education.course02.topic10.hw.employees;

import java.util.List;
import java.util.Map;

public interface DepartmentsServiceV4 {
    String apiInfo();

    Employee employeeWithMaxSalary(Integer departmentId);

    Employee employeeWithMinSalary(Integer departmentId);

    List<Employee> allEmployeeByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> allEmployeeGroupByDepartment();
}
