package ga.repin.education.course01.topic08.hw;

import java.time.LocalDate;

public class Hw08 {
    public static void main() {
        Hw08.soutIsVarYearAleapYear(2000);
        Hw08.soutWhichSoftwareHaveToInstall(1,2010);
        Hw08.soutDeliveryTime(95);
    }

    public static boolean isLeap(int year){
        if ((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0) ) {
            return true;
        }  else {
            return false;
        }
    }

    public static void soutIsVarYearAleapYear(int year) {
        /*
Реализуйте метод, который получает в качестве параметра год, а затем проверяет, является ли он високосным, и выводит
результат в консоль.  Эту проверку вы уже реализовывали в задании по условным операторам.
Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
Результат программы выведите в консоль. Если год високосный, то должно быть выведено “номер года — високосный год”.
Если год не високосный, то, соответственно: “номер года — не високосный год”.
        */
        System.out.println("Задача 1");
        if (Hw08.isLeap(year)) {
            System.out.println(year + " — високосный год");
        } else {
            System.out.println(year + " — НЕ високосный год");
        }
    }

    public static String tellWhichSoftwareHaveToInstall(int clientOS, int clientDeviceYear){
        if (clientOS>1 || clientOS<0){return "ОШИБКА: Можно вводить только 0 и 1 идентификаторы ОС";}
        String[] arrClientOS = {"iOS", "Android"};
        String[] arrSoftVersion = {"лайт версию", "версию"};
        int isaNewSoftVersion = 1;
        if (clientDeviceYear < LocalDate.now().getYear()) {
            isaNewSoftVersion = 0;
        }
        return "Установите " + arrSoftVersion[isaNewSoftVersion] + " приложения для " +
                arrClientOS[clientOS] + " по ссылке";
    }

    public static void soutWhichSoftwareHaveToInstall(int clientOS, int clientDeviceYear) {
        /*
Рефакторинг Hw03.task2 через создание метода
Для обозначения года создания используйте переменную clientDeviceYear, где необходимо указать 2015 год.
Напишите метод, куда подаются два параметра: тип операционной системы (ОС) ( 0 — iOS или 1 — Android ) и год выпуска устройства.
Если устройство старше текущего года, предложите ему установить lite-версию (облегченную версию).
Текущий год можно получить таким способом:
int currentYear = LocalDate.now().getYear();
В результате программа должна выводить в консоль в зависимости от исходных данных, какую версию приложения
(обычную или lite) и для какой ОС (Android или iOS) нужно установить пользователю.
        */
        System.out.println("Задача 2");
        System.out.println(tellWhichSoftwareHaveToInstall(clientOS, clientDeviceYear));
    }

    public static int calculateDeliveryTime(int deliveryDistance){
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
            return deliveryTime;
        } else {
            return 0;
        }
    }

    public static void soutDeliveryTime(int deliveryDistance) {
        /*
Рефакторинг Hw03.task4 через создание метода
Программа выдает сообщение в консоль:
"Потребуется дней: " + срок доставки
Объявите целочисленную переменную deliveryDistance = 95, которая содержит дистанцию до клиента.
        */
        System.out.println("Задача 3");
        int DeliveryTime = calculateDeliveryTime(deliveryDistance);
        if (DeliveryTime !=0 ) {
            System.out.println("Потребуется дней: " + DeliveryTime);
        } else {
            System.out.println("Произошла непонятная фигня!");
        }
    }
}
