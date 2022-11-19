package ga.repin.education.course02.course_work.questions.services;

import ga.repin.education.course02.course_work.questions.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static ga.repin.education.course02.course_work.questions.services.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void checkGetRandomQuestions() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(QUESTION_OBJ_1).thenReturn(QUESTION_OBJ_2);
        when(javaQuestionServiceMock.getAll()).thenReturn( SET_OF_THREE_QUESTIONS);
        Collection<Question> examinerServiceRndOut = examinerService.getQuestions(TWO);
        assertEquals(TWO, examinerServiceRndOut.size());
        List<Question> actual = new ArrayList<>(examinerServiceRndOut);
        List<Question> expected = new ArrayList<>(SET_OF_TWO_QUESTIONS);
        actual.sort(Comparator.comparing(Question::getQuestion));
        expected.sort(Comparator.comparing(Question::getQuestion));
        assertEquals(expected, actual);
    }

}