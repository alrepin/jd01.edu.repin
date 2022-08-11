package course01.course_work;

/*
+Создать внутри класса с методом main поле типа Employee[10], которое будет выполнять роль «хранилища» для записей о сотрудниках.
+Создать статические методы, которые будут взаимодействовать с массивом и предоставлять результат:
+Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
+Посчитать сумму затрат на зарплаты в месяц.
+Найти сотрудника с минимальной зарплатой.
+Найти сотрудника с максимальной зарплатой.
+Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
+Получить Ф. И. О. всех сотрудников (вывести в консоль).
*/
public class EmployeeBook {
    private static Employee[] employees;
    private static int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public static void printFullDataOfAllEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void printFioOfAllEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getFio());
        }
    }

    public static double sumSalaryForEmployees() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static void addEmployee(String fio, int department, double salary) {
        if (size == 0){
            EmployeeBook employeeBook = new EmployeeBook();
        }
        if (size >= employees.length) {
            System.out.println("Книга сотрудников переполнена");
            return;
        }
        Employee newEmployee = new Employee(fio, department, salary);
        employees[size++] = newEmployee;
    }

    public static Employee employeeByID(int id) {
        for (final Employee employee : employees) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        return null;
    }

    public static int idWithMinSalary() {
        double paymentMin = employees[0].getSalary();
        int idMin = employees[0].getID();
        for (final Employee employee : employees) {
            double paymentCurrent = employee.getSalary();
            int idCurrent = employee.getID();
            if (paymentMin > paymentCurrent) {
                paymentMin = paymentCurrent;
                idMin = idCurrent;
            }
        }
        return idMin;
    }

    public static int idWithMaxSalary() {
        double paymentMax = employees[0].getSalary();
        int idMax = employees[0].getID();
        for (final Employee employee : employees) {
            double paymentCurrent = employee.getSalary();
            int idCurrent = employee.getID();
            if (paymentMax < paymentCurrent) {
                paymentMax = paymentCurrent;
                idMax = idCurrent;
            }
        }
        return idMax;
    }

    public static int getCurrentSize() {
        return size;
    }

    public static double avgSalaryForEmployees() {
        double paymentAvg = sumSalaryForEmployees() / getCurrentSize() ;
        return paymentAvg;
    }

    public static void main() {
        EmployeeBook.addEmployee("Иванов Иван Иванович", 5, 120000.50);
        EmployeeBook.addEmployee("Петров Петр Петрович", 1, 140000.20);
        EmployeeBook.addEmployee("Сидоров Сидор Сидорович", 3, 40000.01);
        EmployeeBook.addEmployee("Федоров Федор Федорович", 4, 0.01);
        EmployeeBook.addEmployee("Игорьков Игорь Игоревич", 2, 0.03);
        EmployeeBook.addEmployee("Алексеев Алексей Алексеевич", 5, 120000.51);
        EmployeeBook.addEmployee("Андреев Андрей Андреевич", 1, 140000.19);
        EmployeeBook.addEmployee("Александров Александр Александрович", 3, 40000.02);
        EmployeeBook.addEmployee("Потапов Потап Потапович", 4, 0.02);
        EmployeeBook.addEmployee("Егоров Егор Егорович", 2, 30000.00);
        EmployeeBook.printFullDataOfAllEmployees();
        System.out.printf("Сумма затрат на зарплаты в месяц составила %.2f рублей\n", sumSalaryForEmployees());
        System.out.printf("Минимальная зарплата - %.2f рублей у " + employeeByID(idWithMinSalary()).getFio() +
                "\n", employeeByID(idWithMinSalary()).getSalary());
        System.out.printf("Максимальная зарплата - %.2f рублей у " + employeeByID(idWithMaxSalary()).getFio() +
                "\n", employeeByID(idWithMaxSalary()).getSalary());
        System.out.printf("Средняя зарплата - %.2f рублей\n", avgSalaryForEmployees());
        printFioOfAllEmployees();
    }

}
