package ga.repin.education.course02.topic13.hw.employees;

import ga.repin.education.course02.topic13.hw.employees.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentsServiceV5ImplTest {
    @Mock
    private EmployeeServiceV5Impl employeeService;

    @InjectMocks
    private DepartmentsServiceV5Impl departmentService;

    @BeforeEach
    public void beforeEach() {

        List<Employee> employees = List.of(
                new Employee("Vasil", "Vasilev", 1, 20_000.00),
                new Employee("Igor", "Igorev", 1, 10_000.00),
                new Employee("Anton", "Antonov", 2, 20_000.00),
                new Employee("Alex", "Alexeev", 2, 30_000.00),
                new Employee("Gennadi", "Gennadiev", 2, 38_000.00)
        );
        when(employeeService.listEmployee()).thenReturn(employees);
    }

    public static Stream<Arguments> maxSalaryEmloyees() {
        return Stream.of(
                Arguments.of(1, 20_000.00),
                Arguments.of(2, 38_000.00)
        );
    }

    public static Stream<Arguments> minSalaryEmloyees() {
        return Stream.of(
                Arguments.of(1, 10_000.00),
                Arguments.of(2, 20_000.00)
        );
    }

    @Test
    public void findEmployeeByDepartmentWithEmptyListByUnusedDep() {
        assertTrue(departmentService.allEmployeeByDepartment(3).isEmpty());
    }

    @Test
    public void findEmployeeByDepartment() {
        assertTrue((departmentService.allEmployeeByDepartment(2).size() == 3));
    }

    @Test
    void allEmployeeGroupByDepartment() {
        when(employeeService.listEmployee()).thenReturn(Collections.emptyList());
        assertTrue(departmentService.allEmployeeGroupByDepartment().isEmpty());
    }

    @Test
    public void findEmployeeWithMaxSalaryByUnusedDep() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> departmentService.employeeWithMaxSalary(3));
    }

    @Test
    public void findEmployeeWithMinSalaryByUnusedDep() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> departmentService.employeeWithMinSalary(5));
    }

    @ParameterizedTest
    @MethodSource("maxSalaryEmloyees")
    public void findEmployeeWithMaxSalaryFromDepartment(int department, double expected) {
        assertEquals(departmentService.employeeWithMaxSalary(department).getSalary(), expected);
    }

    @ParameterizedTest
    @MethodSource("minSalaryEmloyees")
    public void findEmployeeWithMinSalaryFromDepartment(int department, double expected) {
        assertEquals(departmentService.employeeWithMinSalary(department).getSalary(), expected);
    }



}