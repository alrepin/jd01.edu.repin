package ga.repin.education.course02.topic08.hw.employees;

import ga.repin.education.course02.topic08.hw.employees.exceptions.ErrorMessage;
import ga.repin.education.course02.topic08.hw.employees.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v3/employee")
@RestController
public class EmployeeControllerV3 {
    private final EmployeeServiceV3 employeeServiceV3;

    public EmployeeControllerV3(EmployeeServiceV3 employeeServiceV3) {
        this.employeeServiceV3 = employeeServiceV3;
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
        return employeeServiceV3.apiInfo();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam(value = "department", required = false) Integer department,
                                @RequestParam(value = "salary", required = false) Double salary
    ) {
        return employeeServiceV3.addEmployee(firstName, lastName, department, salary);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeServiceV3.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeServiceV3.listEmployee();
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return employeeServiceV3.removeEmployee(firstName, lastName);
    }
}
