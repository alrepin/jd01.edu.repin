package ga.repin.education.course02.topic10.hw.employees.exceptions;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends HttpException {
    public EmployeeNotFoundException(String message) {
        super(message);
        super.HttpStatus = HttpStatus.NOT_FOUND;
    }

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
