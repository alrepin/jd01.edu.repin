package ga.repin.education.course02.course_work.questions.controllers;

import ga.repin.education.common.exceptions.ErrorMessage;
import ga.repin.education.common.exceptions.HttpException;
import ga.repin.education.course02.course_work.questions.model.Question;
import ga.repin.education.course02.course_work.questions.services.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

import static ga.repin.education.course02.course_work.HwConstants.HW_ENDPOINT;

//@SessionScope
//@Scope("Session")
//@CrossOrigin
@RestController
@RequestMapping(HW_ENDPOINT)
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage() + " - thrown with Exception " + exception.getClass().toString()));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorMessage> handleException(HttpException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorMessage(exception.getHttpStatus(),exception.getMessage() + " - thrown with Exception " + exception.getClass().toString()));
    }

    @GetMapping()
    public String index(HttpSession session) {
        return examinerService.index(session.getId());
    }

    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount){
        return examinerService.getQuestions(amount);
    }
}
