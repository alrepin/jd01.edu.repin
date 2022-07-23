package hw05;
public class hw05 {
    //Объявление массивов для совместного использования в заданиях
    final static int[] intArr = new int[3];
    final static double[] dblArr = new double[]{1.57, 7.654, 9.986};
    final static boolean[] boolArr = {true, false};

    public static void info() {
        System.out.println("Домашнее задание по уроку \"Массивы\"");
    }
    public static void task1() {
        /*
Объявите три массива:
1. Целочисленный массив, заполненный тремя цифрами – 1, 2 и 3 – с помощью ключевого слова new.
2. Массив, в котором можно хранить три дробных числа – 1.57, 7.654, 9.986 –  сразу заполнив его значениями.
3. Произвольный массив – тип и количество данных определите сами. Самостоятельно выберите способ создания массива:
с помощью ключевого слова или сразу заполненный элементами.
         */
        System.out.println("Задача 1:");
        for (int i = 0; i < intArr.length; i += 1) {
            intArr[i] = (i + 1);
        }
        for (int j : intArr) System.out.print("[" + j + "] ");
        System.out.println("\n----------");
        for (double v : dblArr) System.out.print("[" + v + "] ");
        System.out.println("\n----------");
        for (int i = 0; i < boolArr.length; i += 1) {
            System.out.print("[" + boolArr[i] + "] ");
        }
        System.out.print("\n\n");
    }
    public static void task2() {
    /*
Пройдите по каждому из трех массивов и распечатайте все элементы всех трех массивов, начиная с первого элемента,
через запятую. Запятая между последним элементом одного массива и первым элементом следующего не нужна.
         */
        System.out.println("Задача 2:");
        var delim = "";
        for (int i = 0; i < intArr.length; i+=1){
            if (i < (intArr.length-1)) {
                delim = ", ";
            } else {
                delim = ";\n";
            }
            System.out.print(intArr[i] + delim);
        }

        for (int i = 0; i < dblArr.length; i+=1){
            if (i < (dblArr.length-1)) {
                delim = ", ";
            } else {
                delim = ";\n";
            }
            System.out.print(dblArr[i] +  delim);
        }

        for (int i = 0; i < boolArr.length; i+=1) {
            if (i < (boolArr.length-1)) {
                delim = ", ";
            } else {
                delim = ".\n\n";
            }
            System.out.print(boolArr[i] + delim);
        }
    }
    public static void task3() {
        /*
задача – распечатать все элементы всех трех массивов, но начинать нужно не с первого элемента массива, а с последнего. Элементы должны быть распечатаны через запятую, при этом элементы одного массива располагаются на одной строчке, а элементы другого массива – на другой.
Запятая между последним элементом одного массива и первым элементом следующего не нужна.
Результат должен быть:
3, 2, 1
9.986, 7.654, 1.57
произвольные элементы третьего массива в обратном порядке
         */
        System.out.println("Задача 3:");
        var delim = "";
        for (int i = (intArr.length - 1); i >= 0; i--) {
            if (i > 0) {
                delim = ", ";
            } else {
                delim = ";\n";
            }
            System.out.print(intArr[i] + delim);
        }
        for (int i = (dblArr.length - 1); i >= 0; i--) {
            if (i > 0) {
                delim = ", ";
            } else {
                delim = ";\n";
            }
            System.out.print(dblArr[i] + delim);
        }
        for (int i = (boolArr.length - 1); i >= 0; i--) {
            if (i > 0) {
                delim = ", ";
            } else {
                delim = ".\n\n";
            }
            System.out.print(boolArr[i] + delim);
        }
    }
    public static void task4() {
        /*
Пройдитесь по первому целочисленному массиву и все нечетные числа в нем сделайте четными (нужно прибавить 1).
Важно: код должен работать с любым целочисленным массивом, поэтому для решения задания вам нужно использовать циклы.
Распечатайте результат преобразования в консоль.
         */
        System.out.println("Задача 4:");
        for (int i = 0; i < intArr.length; i += 1) {
            var delim = "";
            if (i < (intArr.length-1)) {
                delim = ", ";
            } else {
                delim = ".\n";
            }
            if (intArr[i] % 2 != 0) {
                intArr[i] = intArr[i]+1;
            }
            System.out.print(intArr[i] + delim);
        }
    }
}
