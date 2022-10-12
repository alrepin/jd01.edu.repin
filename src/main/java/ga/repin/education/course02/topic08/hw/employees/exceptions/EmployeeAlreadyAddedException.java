package ga.repin.education.course02.topic08.hw.employees.exceptions;

import org.springframework.http.HttpStatus;

public class EmployeeAlreadyAddedException extends HttpException {

    public EmployeeAlreadyAddedException() {

    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
        super.HttpStatus = HttpStatus.BAD_REQUEST;

    }

    public EmployeeAlreadyAddedException(HttpStatus httpStatus) {
        super(httpStatus);
    }

    public EmployeeAlreadyAddedException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public EmployeeAlreadyAddedException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause, httpStatus);
    }

    public EmployeeAlreadyAddedException(Throwable cause, HttpStatus httpStatus) {
        super(cause, httpStatus);
    }

    public EmployeeAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus) {
        super(message, cause, enableSuppression, writableStackTrace, httpStatus);
    }
}
