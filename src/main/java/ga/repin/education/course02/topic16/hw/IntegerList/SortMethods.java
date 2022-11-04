package ga.repin.education.course02.topic16.hw.IntegerList;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static ga.repin.education.common.UsefulMethods.generateRandomIntegerArray;

public class SortMethods {
    public static long measurementStartTime;

    public static void main(String[] args) {
        System.out.println(benchmark());
        /*
Bubble sort method performance test
___________________________________
Full clone of generated 100000 random items array with sequences at the edges:
[185238, 172550, 150353, 112264, 173207]...[116405, 131710, 173601, 135369, 146756]
have been sorted for a new array of 100000 items, with:
[100000, 100001, 100003, 100003, 100004]...[199995, 199996, 199996, 199997, 199999]
and completed in 101.422 seconds

Selection sort method performance test
______________________________________
Full clone of generated 100000 random items array with sequences at the edges:
[185238, 172550, 150353, 112264, 173207]...[116405, 131710, 173601, 135369, 146756]
have been sorted for a new array of 100000 items, with:
[100000, 100001, 100003, 100003, 100004]...[199995, 199996, 199996, 199997, 199999]
and completed in 23.918 seconds

Insertion sort method performance test
______________________________________
Full clone of generated 100000 random items array with sequences at the edges:
[185238, 172550, 150353, 112264, 173207]...[116405, 131710, 173601, 135369, 146756]
have been sorted for a new array of 100000 items, with:
[100000, 100001, 100003, 100003, 100004]...[199995, 199996, 199996, 199997, 199999]
and completed in 25.45 seconds

Quick sort method performance test
__________________________________
Full clone of generated 100000 random items array with sequences at the edges:
[185238, 172550, 150353, 112264, 173207]...[116405, 131710, 173601, 135369, 146756]
have been sorted for a new array of 100000 items, with:
[100000, 100001, 100003, 100003, 100004]...[199995, 199996, 199996, 199997, 199999]
and completed in 0.04 seconds

Tim sort method performance test
________________________________
Full clone of generated 100000 random items array with sequences at the edges:
[185238, 172550, 150353, 112264, 173207]...[116405, 131710, 173601, 135369, 146756]
have been sorted for a new array of 100000 items, with:
[100000, 100001, 100003, 100003, 100004]...[199995, 199996, 199996, 199997, 199999]
and completed in 0.076 seconds
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
                headAndTail(generatedRandomIntegerArray, 5, 5),
                headAndTail(sortedArr, 5, 5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        markTheTime(false);
        sortedArr = selectionSortMethod(generatedRandomIntegerArray);
        result = result + benchmarkReport("selection sort",
                headAndTail(generatedRandomIntegerArray, 5, 5),
                headAndTail(sortedArr, 5, 5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        markTheTime(false);
        sortedArr = insertionSortMethod(generatedRandomIntegerArray);
        result = result + benchmarkReport("insertion sort",
                headAndTail(generatedRandomIntegerArray, 5, 5),
                headAndTail(sortedArr, 5, 5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        markTheTime(false);
        sortedArr = quickSort(generatedRandomIntegerArray, 0, generatedRandomIntegerArray.length - 1);
        result = result + benchmarkReport("quick sort",
                headAndTail(generatedRandomIntegerArray, 5, 5),
                headAndTail(sortedArr, 5, 5),
                generatedRandomIntegerArray.length, sortedArr.length, markTheTime(true)
        );

        Integer[] tmp = generatedRandomIntegerArray.clone();
        markTheTime(false);
        Arrays.sort(tmp);
        result = result + benchmarkReport("tim sort",
                headAndTail(generatedRandomIntegerArray, 5, 5),
                headAndTail(tmp, 5, 5),
                generatedRandomIntegerArray.length, tmp.length, markTheTime(true)
        );

        return result;
    }

    private static String headAndTail(Integer[] arr, int head, int tail) {
        return Arrays.toString(Arrays.copyOf(arr, head)) + "..." +
                Arrays.toString(Arrays.copyOfRange(arr, (arr.length - tail), arr.length));
    }

    public static double markTheTime(boolean finish) {
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
                "_________________________________________________________".substring( 0,
                        (method + " method performance test").length()
                ) + "\n" +
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

    public static Integer[] quickSort(Integer[] arr, int begin, int end) {
        Integer[] tmp = arr.clone();
        quickSortRecursion(tmp, begin, end);
        return tmp;
    }

    public static void quickSortRecursion(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSortRecursion(arr, begin, partitionIndex - 1);
            quickSortRecursion(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapItems(arr, i, j);
            }
        }
        swapItems(arr, i + 1, end);
        return i + 1;
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




