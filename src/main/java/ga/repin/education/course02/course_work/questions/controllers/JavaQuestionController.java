package ga.repin.education.course02.course_work.questions.controllers;

import ga.repin.education.common.exceptions.ErrorMessage;
import ga.repin.education.common.exceptions.HttpException;
import ga.repin.education.course02.course_work.questions.model.Question;
import ga.repin.education.course02.course_work.questions.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static ga.repin.education.course02.course_work.HwConstants.HW_ENDPOINT;

//@SessionScope
//@Scope("Session")
//@CrossOrigin
@RestController
@RequestMapping(HW_ENDPOINT)
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
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

    @GetMapping(path = "/java/add")
    public Question add(@RequestParam ("question") String question,
                        @RequestParam ("answer") String answer){
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question remove(@RequestParam ("question") String question,
                           @RequestParam ("answer") String answer){
        return questionService.remove(question, answer);
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAll(){
        return questionService.getAll();
    }
}
