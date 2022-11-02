package ga.repin.education.course02.topic13.hw.employees;

import ga.repin.education.course02.topic13.hw.employees.exceptions.ErrorMessage;
import ga.repin.education.course02.topic13.hw.employees.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ga.repin.education.course02.topic13.hw.HwConstants.HW_ROOT_URL;

@RequestMapping(HW_ROOT_URL + "employee")
@RestController
public class EmployeeControllerV5 {
    private final EmployeeServiceV5 employeeServiceV5;

    public EmployeeControllerV5(EmployeeServiceV5 employeeServiceV5) {
        this.employeeServiceV5 = employeeServiceV5;
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
        return employeeServiceV5.apiInfo();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam(value = "department", required = false) Integer department,
                                @RequestParam(value = "salary", required = false) Double salary
    ) {
        return employeeServiceV5.addEmployee(firstName, lastName, department, salary);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeServiceV5.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeServiceV5.listEmployee();
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return employeeServiceV5.removeEmployee(firstName, lastName);
    }
}
