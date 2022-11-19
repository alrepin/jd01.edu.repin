package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.model.Question;

import java.util.Set;

public class TestData {
    public static final String QUESTION_1 = "Question1";
    public static final String QUESTION_2 = "Question2";
    public static final String QUESTION_3 = "Question3";
    public static final String ANSWER_1 = "Answer1";
    public static final String ANSWER_2 = "Answer2";
    public static final String ANSWER_3 = "Answer3";
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Question QUESTION_OBJ_1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question QUESTION_OBJ_2 = new Question(QUESTION_2, ANSWER_2);
    public static final Question QUESTION_OBJ_3 = new Question(QUESTION_3, ANSWER_3);
    public static final Set<Question> SET_OF_TWO_QUESTIONS = Set.of(QUESTION_OBJ_1, QUESTION_OBJ_2);
    public static final Set<Question> SET_OF_THREE_QUESTIONS = Set.of(QUESTION_OBJ_1, QUESTION_OBJ_2, QUESTION_OBJ_3);
}
