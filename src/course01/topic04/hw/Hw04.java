package course01.topic04.hw;
import java.util.Date;

public class Hw04 {
    public static void main() {
        showNumStrAndInvertStr();
        showFridayReminds();
        showCometVisitYears();
    }

    public static void showNumStrAndInvertStr() {
        System.out.println("Задача 1:");
/*
Выведите в одну строку через пробел числа от 1 до 10, используя цикл while.
На следующей строке выведите числа в обратном порядке от 10 до 1, используя оператор for.
В результате программы вывод должен получиться следующий:
1 2 3 4 5 6 7 8 9 10
10 9 8 7 6 5 4 3 2 1
 */
        int i = 0;
        while (i < 10) {
            i+=1;
            System.out.print (i + " ");
        }
        System.out.print("\n");

        for (; i >= 1; i-=1) {
            System.out.print (i + " ");
        }
        System.out.print("\n");
    }
    public static void showFridayReminds() {
        System.out.println("Задача 2:");
/*
Создайте переменную типа int, которая хранит в себе номер первой пятницы месяца (число от 1 до 7).
Выведите на каждую пятницу месяца (включая полученную) сообщение следующего вида:
"Сегодня пятница, ...-е число. Необходимо подготовить отчет."
В нашем месяце 31 день. В результате у вас должно вывестись от 4 до 5 сообщений с напоминаниями по разным датам.
 */
        int dateOfFirstFri = 1;
        int monthDayCount = 31;
        for (int i = dateOfFirstFri; i <= monthDayCount; i+=7){
            System.out.println("Сегодня пятница,"+ i +"-е число. Необходимо подготовить отчет.");
        }
    }
    public static void showCometVisitYears() {
        System.out.println("Задача 3:");
/*
Для начала нам нужно посчитать траекторию движения кометы, которая пролетает рядом с Землей каждый 79-й год, начиная с нулевого.
Нам нужно узнать, в каких годах комета пролетала рядом с Землей за последние 200 лет и когда мы увидим ее в следующий раз.
В консоль нужно вывести все годы за последние 200 лет, когда появлялась комета, а также следующий год ее появления.
Для вычисления периода можно создать две дополнительные переменные, которые содержат год за 200 лет до текущего (из созданной ранее переменной) в качестве старта и 100 лет после в качестве завершения периода расчета.
В результате решения задачи в консоль должен вывестись следующий результат:
1896
1975
2054
 */
        Date date = new Date();
        int curYear = date.getYear() + 1900;
        int tPeriod = 79;
        int startFromYear = curYear - 200;
        int finishOnYear = curYear + 100;
        int stepVal = 1;
        for (int i = startFromYear; i <= finishOnYear; i+=stepVal){
            if (i % tPeriod == 0) {
                stepVal = tPeriod;
                System.out.println(i);
            }
        }
    }
}
