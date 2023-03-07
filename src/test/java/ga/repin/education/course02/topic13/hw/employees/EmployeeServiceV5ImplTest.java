package ga.repin.education.course02.topic13.hw.employees;

import ga.repin.education.common.model.RndPersonKey;
import ga.repin.education.course02.topic13.hw.employees.exceptions.EmployeeAlreadyAddedException;
import ga.repin.education.course02.topic13.hw.employees.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ga.repin.education.course02.topic13.hw.employees.EmploeeServiceTestConstants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceV5ImplTest {
    private EmployeeServiceV5 emp;

    @BeforeEach
    void setUp() {
        emp = new EmployeeServiceV5Impl();
    }

    @AfterEach
    void tearDown() {
        emp = null;
    }

    public static Stream<Arguments> KeyFields() {
        return Stream.of(
                Arguments.of("Ivan", "Pupkin", 1, 20_000),
                Arguments.of("Fedor", "Pushkin", 1, 30_000),
                Arguments.of("Mariya", "Ivanova", 2, 40_000),
                Arguments.of("Petr", "Petrov", 2, 50_000)
        );
    }

    public static Stream<Arguments> notCorrectKeyFields() {
        return Stream.of(
                Arguments.of("Iv-an", "Pupkin", 1, 20_000),
                Arguments.of(null, "Pushkin", 1, 30_000),
                Arguments.of("Mariya", null, 2, 40_000),
                Arguments.of("Petr", "Petr0v", 2, 50_000)
        );
    }

    @ParameterizedTest
    @MethodSource("KeyFields")
    public void addEmployeeAlreadyAddedException(String name,
                                                 String surname,
                                                 int department,
                                                 double salary) {
        Employee expected = new Employee(name, surname, department, salary);
        assertThat(emp.addEmployee(name, surname, department, salary)).isEqualTo(expected);

        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> emp.addEmployee(name, surname, department, salary));
    }

    @ParameterizedTest
    @MethodSource("notCorrectKeyFields")
    public void addEmployeeThrowHTTPExceptionWhenNotUnicodeFilled(String name,
                                                                  String surname,
                                                                  int department,
                                                                  double salary) {
        assertThrows(Exception.class,
                () -> emp.addEmployee(name, surname, department, salary));
    }

    @Test
    void addEmployeeCapitalizeKeyFields() {
        emp.addEmployee(EMPLOYEE_NAME_LOWERCASE, EMPLOYEE_LASTNAME_LOWERCASE, null, null);
        assertNotNull(emp.findEmployee(EMPLOYEE_NAME_CAPITALIZED,
                EMPLOYEE_LASTNAME_CAPITALIZED));
    }

    @Test
    public void removeNotAddedEmployeeThrow() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> emp.removeEmployee(NOT_ADDED_EMPLOYEE, NOT_ADDED_EMPLOYEE));
    }

    @ParameterizedTest
    @MethodSource("KeyFields")
    public void removeEmployeeCorrect(String name,
                                      String surname,
                                      int department,
                                      double salary) {
        Employee expected = new Employee(name, surname, department, salary);
        assertThat(emp.addEmployee(name, surname, department, salary)).isEqualTo(expected);
        assertThat(emp.removeEmployee(name, surname)).isEqualTo(expected);
        assertFalse(emp.existsEmployee(expected));
    }

    @ParameterizedTest
    @MethodSource("KeyFields")
    void findEmployeeNotFoundException(String name,
                                       String surname,
                                       int department,
                                       double salary) {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> emp.findEmployee(NOT_ADDED_EMPLOYEE, NOT_ADDED_EMPLOYEE));
    }

    @ParameterizedTest
    @MethodSource("KeyFields")
    public void findEmployeeCorrect(String name,
                                    String surname,
                                    int department,
                                    double salary) {
        Employee expected = new Employee(name, surname, department, salary);
        assertEquals(expected, emp.addEmployee(name, surname, department, salary));
        assertEquals(expected, emp.findEmployee(name, surname));
        assertTrue(emp.listEmployee().contains(expected));
    }

    private List<Employee> createTestEmployees(int count) {
        return Stream.iterate(1, i -> i + 1)
                .limit(count)
                .map(i ->
                {
                    RndPersonKey p = new RndPersonKey(getClass().getName());
                    Employee e = new Employee(p.getName(),
                            p.getSurname(),
                            i,
                            10000.00 + 10);
                    return e;
                })
                .collect(Collectors.toList());
    }

    @Test
    public void listEmployee() {
        List<Employee> expected = createTestEmployees(10);
        expected.forEach(e ->
                assertThat(
                        emp.addEmployee(e.getFirstName(), e.getLastName(), e.getDepartment(),
                                e.getSalary())).isEqualTo(e)
        );
        List<Employee> actual = emp.listEmployee();
        for (Employee employee : expected) {
           assertTrue(actual.contains(employee));
        }
    }

}