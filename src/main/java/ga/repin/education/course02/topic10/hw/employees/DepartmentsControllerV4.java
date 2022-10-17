package ga.repin.education.course02.topic10.hw.employees;

import ga.repin.education.course02.topic10.hw.employees.exceptions.ErrorMessage;
import ga.repin.education.course02.topic10.hw.employees.exceptions.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static ga.repin.education.course02.topic10.hw.HwConstants.*;

@RequestMapping(HW_ROOT_URL + "departments")
@RestController
public class DepartmentsControllerV4 {

    private final DepartmentsServiceV4 departmentsServiceV4;

    public DepartmentsControllerV4(DepartmentsServiceV4 departmentsServiceV4) {
        this.departmentsServiceV4 = departmentsServiceV4;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage()));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorMessage> handleException(HttpException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorMessage(exception.getHttpStatus(),exception.getMessage()));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public String devInfo() {
        return departmentsServiceV4.apiInfo();
    }


    @GetMapping("/max-salary")
    public Employee maxSalaryByDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departmentsServiceV4.employeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryByDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departmentsServiceV4.employeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> allEmployeeByDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departmentsServiceV4.allEmployeeByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployeeGroupByDepartment() {
        return departmentsServiceV4.allEmployeeGroupByDepartment();
    }
}
