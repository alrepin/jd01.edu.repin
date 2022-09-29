package ga.repin.education.course02.topic07.hw.employees.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus httpStatus;
    private String message;

}