package ga.repin.education.course05.topic04.hw;

import java.util.Arrays;

public class Hw04 {
    public static void main(String[] args) {
        final int[] inputArray = new int[]{1, 2, 3, 8, 7, 5, 10, 15, 13, 22};
        final int[] resultArray = processingArray(inputArray, 3, 7);
        for (int i = 0; i < resultArray.length; i++) {
            int sourceOrder = i + 3;
            System.out.print("resultArray[" + sourceOrder + "] = " + resultArray[i]);
            if (inputArray[sourceOrder] != resultArray[i]) {
                System.out.print(" (last value was " + inputArray[sourceOrder] + ")");
            }
            System.out.println("");
        }
    }
    
    public static int[] processingArray(int[] arr, int from, int before) {
        final int[] range = Arrays.copyOfRange(arr, from, before + 1);
        for (int i = 0; i < range.length; i++) {
            if (range[i] % 2 == 0) {
                range[i]++;
            }
        }
        return range;
    }
}
