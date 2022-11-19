package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(Integer amount);

    String index(String id);
}
