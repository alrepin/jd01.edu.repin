package ga.repin.education.course02.topic10.hw.employees;

import ga.repin.education.course02.topic10.hw.employees.exceptions.ErrorMessage;
import ga.repin.education.course02.topic10.hw.employees.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ga.repin.education.course02.topic10.hw.HwConstants.*;

@RequestMapping(HW_ROOT_URL + "employee")
@RestController
public class EmployeeControllerV4 {
    private final EmployeeServiceV4 employeeServiceV4;

    public EmployeeControllerV4(EmployeeServiceV4 employeeServiceV4) {
        this.employeeServiceV4 = employeeServiceV4;
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
        return employeeServiceV4.apiInfo();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam(value = "department", required = false) Integer department,
                                @RequestParam(value = "salary", required = false) Double salary
    ) {
        return employeeServiceV4.addEmployee(firstName, lastName, department, salary);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeServiceV4.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeServiceV4.listEmployee();
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return employeeServiceV4.removeEmployee(firstName, lastName);
    }
}
