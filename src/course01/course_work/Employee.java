package course01.course_work;
/*
+Создать класс Employee, который содержит информацию о Ф. И. О., отделе и зарплате сотрудника.
+Отделы для простоты должны быть названы от 1 до 5.
+Добавить статическую переменную-счетчик, которая будет отвечать за id.
+Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
+Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
+Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
+По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем
(включая id, который нужно получить из счетчика).
*/

public class Employee {
    private int id;
    private String fio;
    private int department;
    private double salary;

    private static int counter = 1;

    public Employee(String fio, int department, double salary) {
        this.setDepartment(department);
        this.id = counter;
        counter++;
        this.fio = fio;
        this.salary = salary;
    }
    public int getID(){
        return this.id;
    }

    public String getFio(){
        return this.fio;
    }

    public int getDepartment(){
        return this.department;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setDepartment(int department) {
        if ((department < 0) || (department > 5)) {
            throw new IllegalArgumentException("Департаменты в диапазоне от 1 до 5");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + this.id + ", fio=\"" + this.fio + "\", department=" + this.department + ", salary=" + this.salary;
    }
}
