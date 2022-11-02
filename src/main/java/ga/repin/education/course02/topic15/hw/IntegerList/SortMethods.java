package ga.repin.education.course02.topic15.hw.IntegerList;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import static ga.repin.education.common.UsefulMethods.*;

public class SortMethods {
    public static long measurementStartTime;

    public static void main(String[] args) {
        System.out.println(benchmark());
        /*
Bubble sort method performance test
Full clone of generated 100000 random items array with sequences at the edges:
[165818, 132483, 154770, 110288, 127143]...[170690, 193590, 120070, 174396, 133819]
have been sorted for a new array of 100000 items, with:
[100003, 100004, 100005, 100005, 100009]...[199993, 199995, 199997, 199998, 199998]
and completed in 100.93 seconds

Selection sort method performance test
Full clone of generated 100000 random items array with sequences at the edges:
[165818, 132483, 154770, 110288, 127143]...[170690, 193590, 120070, 174396, 133819]
have been sorted for a new array of 100000 items, with:
[100003, 100004, 100005, 100005, 100009]...[199993, 199995, 199997, 199998, 199998]
and completed in 21.362 seconds

Insertion sort method performance test
Full clone of generated 100000 random items array with sequences at the edges:
[165818, 132483, 154770, 110288, 127143]...[170690, 193590, 120070, 174396, 133819]
have been sorted for a new array of 100000 items, with:
[100003, 100004, 100005, 100005, 100009]...[199993, 199995, 199997, 199998, 199998]
and completed in 25.554 seconds

Tim sort method performance test
Full clone of generated 100000 random items array with sequences at the edges:
[165818, 132483, 154770, 110288, 127143]...[170690, 193590, 120070, 174396, 133819]
have been sorted for a new array of 100000 items, with:
[100003, 100004, 100005, 100005, 100009]...[199993, 199995, 199997, 199998, 199998]
and completed in 0.083 seconds
        */
    }

    public static String benchmark() {
        Integer[] sortedArr;
        String result = "";
        System.out.println("please wait several minutes..");
        Integer[] generatedRandomIntegerArray = generateRandomIntegerArray();

        markTheTime(false);
        sortedArr = bubbleSortMethod(generatedRandomIntegerArray);
        result = result + benchmarkReport("bubble sort",
                headAndTail(generatedRandomIntegerArray, 5,5),
                headAndTail(sortedArr, 5,5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        markTheTime(false);
        sortedArr = selectionSortMethod(generatedRandomIntegerArray);
        result = result + benchmarkReport("selection sort",
                headAndTail(generatedRandomIntegerArray, 5,5),
                headAndTail(sortedArr, 5,5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        markTheTime(false);
        sortedArr = insertionSortMethod(generatedRandomIntegerArray);
        result = result + benchmarkReport("insertion sort",
                headAndTail(generatedRandomIntegerArray, 5,5),
                headAndTail(sortedArr, 5,5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        Integer[] tmp = generatedRandomIntegerArray.clone();
        markTheTime(false);
        Arrays.sort(tmp);
        result = result + benchmarkReport("tim sort",
                headAndTail(generatedRandomIntegerArray, 5,5),
                headAndTail(tmp, 5,5),
                generatedRandomIntegerArray.length, tmp.length, markTheTime(true)
        );

        return result;
    }

    private static String headAndTail(Integer[] arr, int head, int tail) {
        return Arrays.toString(Arrays.copyOf(arr, head)) + "..." +
                Arrays.toString(Arrays.copyOfRange(arr,(arr.length-tail),arr.length));
    }

    private static double markTheTime(boolean finish) {
        if (finish) {
            return (System.currentTimeMillis() - measurementStartTime) / 1000.0;
        } else {
            measurementStartTime = System.currentTimeMillis();
        }
        return measurementStartTime;
    }

    private static String benchmarkReport(String method, String arrPrintBefore, String arrPrintAfter,
                                          int sourceArrLength, int resultArrLength, double timeout) {
        return "\n" + StringUtils.capitalize(method) + " method performance test\n" +
                "Full clone of generated " + sourceArrLength + " random items" +
                " array with sequences at the edges:\n" +
                arrPrintBefore + "\nhave been sorted for a new array of " + resultArrLength + " items" +
                ", with:\n" + arrPrintAfter + "\nand completed in " + timeout + " seconds\n";
    }

    private static void swapItems(Integer[] arr, int A, int B) {
        int tmp = arr[A];
        arr[A] = arr[B];
        arr[B] = tmp;
    }

    public static Integer[] bubbleSortMethod(Integer[] arr) {
        Integer[] tmp = arr.clone();
        for (int i = 0; i < tmp.length - 1; i++) {
            for (int j = 0; j < tmp.length - 1 - i; j++) {
                if (tmp[j] > tmp[j + 1]) {
                    swapItems(tmp, j, j + 1);
                }
            }
        }
        return tmp;
    }

    public static Integer[] selectionSortMethod(Integer[] arr) {
        Integer[] tmp = arr.clone();
        for (int i = 0; i < tmp.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tmp.length; j++) {
                if (tmp[j] < tmp[minIndex]) {
                    minIndex = j;
                }
            }
            swapItems(tmp, i, minIndex);
        }
        return tmp;
    }

    public static Integer[] insertionSortMethod(Integer[] arr) {
        Integer[] tmp = arr.clone();
        for (int i = 1; i < tmp.length; i++) {
            Integer temp = tmp[i];
            int j = i;
            while (j > 0 && tmp[j - 1] >= temp) {
                tmp[j] = tmp[j - 1];
                j--;
            }
            tmp[j] = temp;
        }
        return tmp;
    }
}




