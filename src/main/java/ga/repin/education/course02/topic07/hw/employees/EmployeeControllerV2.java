package ga.repin.education.course02.topic07.hw.employees;

import ga.repin.education.course02.topic07.hw.employees.exceptions.ErrorMessage;
import ga.repin.education.course02.topic07.hw.employees.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v2/employee")
@RestController
public class EmployeeControllerV2 {
    private final EmployeeServiceV2 employeeServiceV2;

    public EmployeeControllerV2(EmployeeServiceV2 employeeServiceV2) {
        this.employeeServiceV2 = employeeServiceV2;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public String devInfo() {
        return employeeServiceV2.apiInfo();
    }



    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorMessage> handleException(HttpException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorMessage(exception.getHttpStatus(),exception.getMessage()));
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/add")
    public Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return employeeServiceV2.addEmployee(firstName, lastName);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeServiceV2.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeServiceV2.listEmployee();
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return employeeServiceV2.removeEmployee(firstName, lastName);
    }
}
