package hw02;
import java.text.DecimalFormat;
import java.util.Scanner;
public class hw02 {
    public static void info() {
        System.out.println("Домашнее задание по уроку \"Переменные\"");
    }
    public static void task1() {
        //Объявите переменные всех типов, что мы изучили на уроке, и присвойте им любые значения (инициализируйте их).
        System.out.println("Задача 1");
        char charMyVal = 65;
        byte byteMyVal = 2;
        short shortMyVal = 3;
        int intMyVal = 1;
        long longMyVal = 5L;
        float fltMyVal = 4.5f;
        double dblMyVal = 3.5;
        boolean boolMyVal = true;
        System.out.println("65 символ: " + charMyVal);

    }
    public static void task2() {
        /*Вес одного боксера – 78,2 кг
          Вес второго боксера – 82,7 кг
          Подсчитайте и выведите в консоль общий вес двух бойцов.
          Подсчитайте и выведите в консоль разницу между весами бойцов.*/
        System.out.println("Задача 2");
        double dblFighter1 = 78.2;
        double dblFighter2 = 82.7;
        System.out.println("Общий вес бойцов: " + Double.toString(dblFighter1 + dblFighter2) + " кг");
        System.out.println("Разность веса бойцов: " + Double.toString(Math.abs(dblFighter1 - dblFighter2)) + " кг");

    }
    public static void task3() {
        /*Подсчитайте вес (количество грамм) спорт-завтрака, а затем переведите его в килограммы.
         * возможные ингридиенты:
         * – Бананы – 5 штук (1 банан - 80 грамм);
         * – Молоко – 200 мл (100 мл = 105 грамм);
         * – Мороженое пломбир – 2 брикета по 100 грамм;
         * – Яйца сырые – 4 яйца (1 яйцо - 70 грамм).
         * */
        System.out.println("Задача 3");
        Scanner sc = new Scanner(System.in);
        int intBananaItemWeight = 80;
        int intMilkItemWeight = 105;
        int intIcecreamItemWeight = 100;
        int intEggItemWeight = 70;

        int intEggItemCount = 0;
        int intBananaItemCount = 0;
        int intMilkItemCount = 0;
        int intIcecreamItemCount = 0;

        System.out.println("Кол-во яиц :");
        intEggItemCount = sc.nextInt();
        System.out.println("Кол-во бананов :");
        intBananaItemCount = sc.nextInt();
        System.out.println("Брикетов мороженного по 100 г :");
        intIcecreamItemCount = sc.nextInt();
        System.out.println("Пакетов молока по 100 мл :");
        intMilkItemCount = sc.nextInt();
        sc.close();
        System.out.println("Вес завтрака (г): " +
                (intEggItemCount * intEggItemWeight + intBananaItemCount * intBananaItemWeight +
                        intMilkItemCount * intMilkItemWeight + intIcecreamItemWeight * intIcecreamItemCount));
        System.out.println("Вес завтрака (кг): " +
                ((double) (intEggItemCount * intEggItemWeight + intBananaItemCount * intBananaItemWeight +
                        intMilkItemCount * intMilkItemWeight + intIcecreamItemWeight * intIcecreamItemCount) / (double) 1000));

    }
    public static void task4() {
        /*
        спортсмену нужно сбросить 7 кг
        Посчитайте, сколько дней уйдёт на похудение, если спортсмен будет терять каждый день по 250 грамм и сколько, если каждый день будет худеть на 500 грамм.
        Посчитайте, сколько может потребоваться дней в среднем, чтобы добиться результата похудения.
        Результаты подсчетов выведите в консоль. */
        System.out.println("Задача 4");
        DecimalFormat df = new DecimalFormat("###.#");
        int intMinDayDelta = 250;
        int intMaxDayDelta = 500;
        double dblMidDayDelta = (intMinDayDelta + intMaxDayDelta) / 2;
        System.out.println("Если сильно поднапрячься, то похудеем на 7 кг. за " + df.format(7000 / intMaxDayDelta) + " дней.");
        System.out.println("Для похудения на 7 кг. с минимальными усилиями потребуется " + df.format(7000 / intMinDayDelta) + " дней.");
        System.out.println("Для похудения на 7 кг. в среднем потребуется " + df.format(7000 / dblMidDayDelta) + " дней.");
    }
    public static void task5() {
        /*
        Маша получает 67 760 рублей в месяц
        Денис получает 83 690 рублей в месяц
        Кристина получает 76 230 рублей в месяц
        Каждому нужно увеличить зарплату на 10% от текущей месячной. Дополнительно руководитель попросил посчитать разницу между годовым доходом с нынешней зарплатой и после повышения. Посчитайте, сколько будет получать каждый из сотрудников, а также разницу между годовым доходом до и после повышения.
        Выведите в консоль информацию по каждому сотруднику.
        Например, “Маша теперь получает **** рублей. Годовой доход вырос на **** рублей”.*/
        System.out.println("Задача 5");
        DecimalFormat df = new DecimalFormat("###.#");
        double dblMonthSalaryMaria = 67760;
        double dblMonthSalaryDenis = 83690;
        double dblMonthSalaryKris = 76230;
        System.out.println("Маша теперь ежемесячно получает " + df.format(dblMonthSalaryMaria * 1.1) + " рублей. Годовой доход вырос на " +
                df.format(dblMonthSalaryMaria * 0.1 * 12 )+ " рублей.");
        System.out.println("Денис теперь ежемесячно получает " + df.format(dblMonthSalaryDenis * 1.1) + " рублей. Годовой доход вырос на " +
                df.format(dblMonthSalaryDenis * 0.1 * 12 )+ " рублей.");
        System.out.println("Кристина теперь ежемесячно получает " + df.format(dblMonthSalaryKris * 1.1) + " рублей. Годовой доход вырос на " +
                df.format(dblMonthSalaryKris * 0.1 * 12 )+ " рублей.");

    }
}
