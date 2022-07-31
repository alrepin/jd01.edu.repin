package hw07;
public class Hw07 {
    static String fullName = "";
    public static void info() {
        System.out.println("Домашнее задание по уроку \"Строки\"");
    }
    public static void lesson() {
        String phone = "+960-415-75-37";
        phone = phone.replace(" ", "");
        phone = phone.replace("-", "");
        phone = phone.replace("+", "");
        if (phone.length() == 10) {
           phone = "7" + phone;
        } else if (phone.length() > 11) {
            throw new RuntimeException("Телефон слишком длинный");
        } else if (phone.length() < 10) {
            throw new RuntimeException("Телефон слишком короткий");
        } else if (phone.length() == 11 && phone.charAt(0) != '7') {
            throw new RuntimeException("Среди нас посторонний");
        }
        System.out.println("phone = " + phone);
        String expectedPhone = "79604157537";
        if (phone.equals(expectedPhone)) {
            System.out.println("Успех");
        } else {
            System.out.println("Неудача");
        }
    }
    public static void task1() {
        System.out.println("Задача 1");
        /*
Напишите четыре строки:
первая с именем firstName — для хранения имени;
вторая с именем middleName — для хранения отчества;
третья с именем lastName — для хранения фамилии;
четвертая с именем fullName — для хранения Ф. И. О. сотрудника в формате "Фамилия Имя Отчество".
Выведите в консоль фразу: “ФИО сотрудника — ….”
В качестве данных для задачи используйте “Ivanov Ivan Ivanovich”.
        */
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        fullName = lastName + ' ' + firstName + ' ' + middleName;
        System.out.println("ФИО сотрудника — " + fullName + '.');
    }
    public static void task2() {
        System.out.println("Задача 2");
        /*
изменить написание Ф. И. О. сотрудника с  “Ivanov Ivan Ivanovich” на полностью заглавные буквы.
В качестве строки с исходными данными используйте строку fullName.
Результат программы выведите в консоль в формате: ”Данные ФИО сотрудника для заполнения отчета — …”
        */
        if (!fullName.isEmpty()) {
            fullName = fullName.toUpperCase();
            System.out.println("Данные ФИО сотрудника для заполнения отчета — " + fullName + '.');
        } else {
            System.out.println("Данные о сотруднике отсутствуют");
        }
    }
    public static void task3() {
        System.out.println("Задача 3");
        /*
заменить символ “ё” на символ “е”.
В качестве исходных данных используйте строку fullName и данные в ней “Иванов Семён Семёнович”.
Выведите результат программы в консоль в формате: ”Данные ФИО сотрудника — ...”
        */
        String fullName = "Иванов Семён Семёнович";
        fullName = fullName.replace("ё","е");
        System.out.println("Данные ФИО сотрудника — " + fullName + '.');
    }
}
