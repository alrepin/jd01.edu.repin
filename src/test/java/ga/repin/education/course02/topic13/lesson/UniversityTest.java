package ga.repin.education.course02.topic13.lesson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UniversityTest {
    private final Student student = new Student("Евгений", true);

    @Mock
    private StudentValueGenerator studentValueGenerator;

    @InjectMocks
    private University university;

    /*@BeforeEach
    public void setUp() {
        university = new University(studentValueGenerator);
    }*/

    @Test
    void addStudent() {
    }

    @Test
    void getAllStudentsInOrder() {
        Mockito.when(studentValueGenerator.generateAgeInRange(anyInt(),anyInt())).thenReturn(55);
        university.addStudentInRange(student, 50, 100);

        InOrder inOrder = Mockito.inOrder(studentValueGenerator);

        List<Student> actual = university.getAllStudents();

        inOrder.verify(studentValueGenerator,times(2)).generateAge();
        inOrder.verify(studentValueGenerator).generateAgeInRange(anyInt(),anyInt());
        assertEquals(55, actual.get(0).getAge());
    }

    @Test
    void getAllStudentsWithCountAgeGenerate() {
        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);

        university.addStudent(student);
        List<Student> actual = university.getAllStudents();
        assertEquals(50, actual.get(0).getAge());

        Mockito.verify(studentValueGenerator, times(2)).generateAge();

    }

    @Test
    void getAllStudentsOver50yo() {
        Mockito.when(studentValueGenerator.generateAgeInRange(anyInt(),anyInt())).thenReturn(55);
        university.addStudentInRange(student, 50, 100);
        List<Student> actual = university.getAllStudents();
        assertEquals(55, actual.get(0).getAge());
    }

    @Test
    void getAllStudents() {
        assertNotNull(studentValueGenerator);
        //предпочтительно
        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);
        university.addStudent(student);
        List<Student> actual = university.getAllStudents();
        assertEquals(50, actual.get(0).getAge());
    }

    @Test
    void getAllStudents2() {
        assertNotNull(studentValueGenerator);
        Mockito.doReturn(50).when(studentValueGenerator).generateAge();
        university.addStudent(student);
        List<Student> actual = university.getAllStudents();
        assertEquals(50, actual.get(0).getAge());
    }

    @Test
    void testGetAllStudents() {
    }
}