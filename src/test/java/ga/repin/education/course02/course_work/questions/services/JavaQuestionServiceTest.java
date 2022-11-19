package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static ga.repin.education.course02.course_work.questions.services.TestData.*;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService o = new JavaQuestionService();

    @Test
    public void checkAdd() {
        Question expected = new Question(QUESTION_1, ANSWER_1);
        assertEquals(ZERO, o.getAll().size());
        assertFalse(o.getAll().contains(expected));
        o.add(QUESTION_1, ANSWER_1);
        assertTrue(o.getAll().contains(expected));
        expected = QUESTION_OBJ_2;
        assertFalse(o.getAll().contains(expected));
        expected = o.add(QUESTION_OBJ_2);
        assertEquals(TWO, o.getAll().size());
        assertTrue(o.getAll().contains(expected));
    }

    @Test
    public void checkRemove() {
        Question actual = o.add(QUESTION_1, ANSWER_1);
        assertEquals(ONE, o.getAll().size());
        Question expected = QUESTION_OBJ_1;
        assertTrue(o.getAll().contains(expected));
        actual = o.remove(QUESTION_1, ANSWER_1);
        assertEquals(expected, actual);
        assertTrue(o.getAll().isEmpty());
        assertFalse(o.getAll().contains(expected));
    }

    @Test
    public void checkEmptyCollection() {
        assertIterableEquals(emptyList(), o.getAll());
    }

    @Test
    public void checkFilledCollection() {
        o.add(QUESTION_OBJ_1);
        o.add(QUESTION_2, ANSWER_2);
        Collection<Question> expected = List.of(QUESTION_OBJ_1, QUESTION_OBJ_2);
        Collection<Question> actual = o.getAll();
        assertIterableEquals(expected, actual);
    }
}