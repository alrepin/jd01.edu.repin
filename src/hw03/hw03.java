package hw03;

import java.util.Scanner;

public class hw03 {
    public static void info() {
        System.out.println("Домашнее задание по уроку \"Условные операторы\"");
    }
    public static void task1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ваша ОС: введите 0 — iOS, 1 — Android");
        int clientOS = sc.nextInt();
        if (clientOS == 0 ) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }  else if (clientOS == 1 ) {
            System.out.println("Установите версию приложения для Android по ссылке");
        } else {
            System.out.println("Давай досвиданья!");
        }

    }
    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ваша ОС: введите 0 — iOS, 1 — Android");
        int clientOS = sc.nextInt();
        switch (clientOS) {
            case 1:
            case 0:
                break;
            default:
                System.out.println("Можно вводить только 0 и 1");
                return;
        }
        System.out.println("Введите год производства Вашего устройства");
        int clientDeviceYear = sc.nextInt();
        //sc.close();

        if (clientDeviceYear < 2015) {
            clientDeviceYear = 10;
        } else {
            clientDeviceYear = 20;
        }

        switch (clientDeviceYear+clientOS) {
            case 10:
                System.out.println("Установите лайт версию приложения для iOS по ссылке");
                break;
            case 11:
                System.out.println("Установите лайт версию приложения для Android по ссылке");
                break;
            case 20:
                System.out.println("Установите версию приложения для iOS по ссылке");
                break;
            case 21:
                System.out.println("Установите версию приложения для Android по ссылке");
                break;
            default:
                System.out.println("Что-то пошло не так)");
        }
    }
    public static void task3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год для проверки на високосность:");
        double year = sc.nextDouble();

        if ((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0) ) {
            System.out.println("Вы ввели високосный год");
        }  else {
            System.out.println("Вы ввели НЕ високосный год");
        }
        //sc.close();
    }
    public static void task4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дистанцию до клиента в пределах тарифной сетки до 100 км.:");
        int deliveryDistance = sc.nextInt();

        int deliveryTime = 0;
        boolean flagErr = false;
        switch ((deliveryDistance-1) / 20) {
            case 0:
                deliveryTime = 1;
                break;
            case 1:
            case 2:
                deliveryTime = 2;
                break;
            case 3:
            case 4:
                deliveryTime = 3;
                break;
            default:
                flagErr = true;
        }
        if (!flagErr) {
            System.out.println("Потребуется дней: " + deliveryTime);
        } else {
            System.out.println("Что-то пошло не так)");
        }
        //sc.close();
    }
    public static void task5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер месяца (1-12):");
        int monthNumber = sc.nextInt();
        //sc.close();
        if ((monthNumber > 12) || (monthNumber < 1)) {
            System.out.println("Можно вводить только целые числа от 1 до 12");
            return;
        }
        var seasonName = "";
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                seasonName = "Зимой";
                break;
            case 3:
            case 4:
            case 5:
                seasonName = "Весной";
                break;
            case 6:
            case 7:
            case 8:
                seasonName = "Летом";
                break;
            case 9:
            case 10:
            case 11:
                seasonName = "Осенью";
                break;
            default:
                return;
        }
        System.out.println("Месяц с номером " + monthNumber + " у нас " + seasonName);

    }
}
