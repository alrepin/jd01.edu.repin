package hw06;
public class hw06 {
    static int[] mnthRprt = generateRandomArray();
    static int paymentSum = 0;
    public static void info() {
        System.out.println("Домашнее задание по уроку \"Массивы ч.2\"");
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    public static void task1() {
        /*
посчитать сумму всех выплат за месяц.
Нужно написать программу, которая решит эту задачу, и вывести в консоль результат
в формате: «Сумма трат за месяц составила … рублей».
         */
        System.out.println("Задача 1:");
        for (int curPayment : mnthRprt) {
            paymentSum += curPayment;
        }
        System.out.println("Сумма трат за месяц составила " + paymentSum + " рублей.");
    }
    public static void task2() {
        /*
найти минимальную и максимальную трату за день и вывести в консоль результат
в формате: «Минимальная сумма трат за день составила … рублей. Максимальная сумма трат за день составила … рублей».
         */
        System.out.println("Задача 2:");
        int paymentMin = mnthRprt[0];
        int paymentMax = mnthRprt[0];
        for (int curPayment : mnthRprt) {
            if (paymentMin > curPayment) {
                paymentMin = curPayment;
            }
            if (paymentMax < curPayment) {
                paymentMax = curPayment;
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + paymentMin + " рублей.");
        System.out.println("Максимальная сумма трат за день составила " + paymentMax + " рублей.");
    }
    public static void task3() {
        /*
посчитать среднее значение трат за месяц (то есть сумму всех трат за месяц поделить на количество дней),
и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
         */
        System.out.println("Задача 3:");
        double paymentAvg = (double) paymentSum / mnthRprt.length;
        System.out.printf("Средняя сумма трат за месяц составила %.2f рублей\n", paymentAvg);
    }
    public static void task4() {
        /*
Данные с именами сотрудников хранятся в виде массива символов (char[]).
Напишите код, который в случае бага, когда Ф. И. О. сотрудников начали отображаться в обратную сторону
будет выводить Ф. И. О. сотрудников в корректном виде. В качестве данных для массива используйте:
char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
В результате в консоль должно быть выведено "Ivanov Ivan".
         */
        System.out.println("Задача 4:");
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = reverseFullName.length - 1; i >= 0 ; i--) {
            System.out.print(reverseFullName[i]);
        }
    }
}
