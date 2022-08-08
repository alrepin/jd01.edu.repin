package course01.topic03.hw;

public class Hw03 {
    public static void main() {
        whichSoftwareHaveToInstallSimple();
        whichSoftwareHaveToInstall();
        checkYearForLeap();
        calculateDeliveryTimeSimple();
        defineSeasonByMonthNumber();
    }

    public static void whichSoftwareHaveToInstallSimple() {
        System.out.println("Задача 1");
        int clientOS = 1;
        if (clientOS == 0 ) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }  else if (clientOS == 1 ) {
            System.out.println("Установите версию приложения для Android по ссылке");
        } else {
            System.out.println("Давай досвиданья!");
        }

    }

    public static void whichSoftwareHaveToInstall() {
        System.out.println("Задача 2");
        int clientOS = 0;
        int clientDeviceYear = 2022;
        switch (clientOS) {
            case 1:
            case 0:
                break;
            default:
                System.out.println("Можно вводить только 0 и 1");
                return;
        }
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

    public static void checkYearForLeap() {
        System.out.println("Задача 3");
        int year = 1900;
        if ((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0) ) {
            System.out.println("Вы ввели високосный " + year + " год ");
        }  else {
            System.out.println("Вы ввели НЕ високосный " + year + " год");
        }
    }

    public static void calculateDeliveryTimeSimple() {
        System.out.println("Задача 4");
        int deliveryDistance = 30;
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
            System.out.println("Потребуется дней: " + deliveryTime + " для дистанции = " + deliveryDistance + " км.");
        } else {
            System.out.println("Что-то пошло не так)");
        }
    }

    public static void defineSeasonByMonthNumber() {
        System.out.println("Задача 5");
        int monthNumber = 5;
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
