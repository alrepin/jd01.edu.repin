package ga.repin.education.course02.course_work.questions.exceptions;

import ga.repin.education.common.exceptions.HttpException;

public class QuestionNotFoundException extends HttpException {
    public QuestionNotFoundException() {
        super("Question does not exist", org.springframework.http.HttpStatus.NOT_FOUND);
    }
    public QuestionNotFoundException(String message) {
        super(message);
    }
}
