package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.exceptions.AmountWrongNumberException;
import ga.repin.education.course02.course_work.questions.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static ga.repin.education.common.HtmlWrappers.*;

@Service
//@Scope("Session")
@SessionScope
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) {
        Set<Question> questions = new HashSet<>();
        if (amount > questionService.getAll().size() || amount < 1) {
            throw new AmountWrongNumberException();
        }
        else {
            while (questions.size() < amount) {
                questions.add(questionService.getRandomQuestion());
            }
        }

        return questions;
    }

    public String index(String id) {
        return mainTheme(
                "Questions API Description" +
                        HR +
                        "A JSON interface is offered to manage exam questions/answers via HTTP.<br>" +
                        "API access is provided at the URLs used in this demo below.<br>" +
                        questionsSnippet(id)
        );
    }

}
