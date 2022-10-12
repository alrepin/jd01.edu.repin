package ga.repin.education.course02.topic05.hw.employees.exceptions;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {
    protected HttpStatus HttpStatus;

    public org.springframework.http.HttpStatus getHttpStatus() {
        return HttpStatus;
    }

    public HttpException() {
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(org.springframework.http.HttpStatus httpStatus) {
        HttpStatus = httpStatus;
    }

    public HttpException(String message, org.springframework.http.HttpStatus httpStatus) {
        super(message);
        HttpStatus = httpStatus;
    }

    public HttpException(String message, Throwable cause, org.springframework.http.HttpStatus httpStatus) {
        super(message, cause);
        HttpStatus = httpStatus;
    }

    public HttpException(Throwable cause, org.springframework.http.HttpStatus httpStatus) {
        super(cause);
        HttpStatus = httpStatus;
    }

    public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, org.springframework.http.HttpStatus httpStatus) {
        super(message, cause, enableSuppression, writableStackTrace);
        HttpStatus = httpStatus;
    }

    public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }
}
