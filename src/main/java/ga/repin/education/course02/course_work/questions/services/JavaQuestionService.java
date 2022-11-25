package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.exceptions.QuestionNotFoundException;
import ga.repin.education.course02.course_work.questions.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
@SessionScope
//@CrossOrigin
//@Scope("Session")
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        checkNull(question, answer);
        Question newQuestion =  new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        checkNull(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        checkNull(question, answer);
        Question question1 = new Question(question, answer);
        if (!questions.remove(question1)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question1);
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    private void checkNull(String question, String answer) {
        if (question == null || answer == null) {
            throw new NullPointerException();
        }
    }

    private void checkNull(Question question) {
        checkNull(question.getQuestion(),question.getAnswer());
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }
}
