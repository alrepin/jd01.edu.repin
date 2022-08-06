package lesson08;

import hw08.Hw08;

public class Lesson08 {
    public static void main(String[] args) {
        lesson();
    }

    public static int sum(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void printIssues(int issueCount){
        System.out.println(issueCount);
    }

    public static void printSeparator(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("----------------------------------------");
    }

    public static void lesson() {
        System.out.println("Занятие\n");
        int[] issuesByMonths = {4, 6, 7, 9, 2, 5, 12, 3, 7, 10, 6, 7, 1, 8,};
        printSeparator();
        for (int i = 0; i < issuesByMonths.length; i++) {
            printIssues(issuesByMonths[i]);
            if ((i+1)%3 == 0) {
                printSeparator();
            }
        }
        printSeparator();
        int total = sum(issuesByMonths);
        printIssues(total);
    }
}
