package ga.repin.education.course02.topic05.hw.employees;

import ga.repin.education.course02.topic05.hw.employees.exceptions.ErrorMessage;
import ga.repin.education.course02.topic05.hw.employees.exceptions.EmployeeAlreadyAddedException;
import ga.repin.education.course02.topic05.hw.employees.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public String devInfo() {
        return employeeService.apiInfo();
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
        return employeeService.addEmployee(firstName, lastName);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.listEmployee();
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return employeeService.removeEmployee(firstName, lastName);
    }
}
