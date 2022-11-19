package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
