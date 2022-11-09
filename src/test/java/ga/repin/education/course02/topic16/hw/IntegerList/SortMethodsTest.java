package ga.repin.education.course02.topic16.hw.IntegerList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static ga.repin.education.common.UsefulMethods.generateRandomIntegerArray;
import static ga.repin.education.course02.topic16.hw.IntegerList.SortMethods.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Disabled until change in sort methods")
class SortMethodsTest {
    private final static Integer[] RND_ARR = generateRandomIntegerArray(100_000);

    private final static long TEST_TIMEOUT = 5555;


    @Test
    @Disabled("enough passed ones")
    public void checkTimeMeasurement() throws InterruptedException {
        markTheTime(false);
        TimeUnit.MILLISECONDS.sleep(TEST_TIMEOUT);
        double actual = markTheTime(true);
        actual *= 1000;
        assertEquals(TEST_TIMEOUT, actual);
    }

    @Test
    @Disabled("enough passed ones")
    public void checkSortMethodsResults() {
        Integer[] actual;

        assertFalse(isArrSorted(RND_ARR));

        actual = insertionSortMethod(RND_ARR);
        assertTrue(isArrSorted(actual));
        assertEquals(RND_ARR.length, actual.length);
        assertEquals(sum(RND_ARR), sum(actual));

        actual = quickSort(RND_ARR, 0, RND_ARR.length - 1);
        assertTrue(isArrSorted(actual));
        assertEquals(RND_ARR.length, actual.length);
        assertEquals(sum(RND_ARR), sum(actual));

        actual = selectionSortMethod(RND_ARR);
        assertTrue(isArrSorted(actual));
        assertEquals(RND_ARR.length, actual.length);
        assertEquals(sum(RND_ARR), sum(actual));

        actual = bubbleSortMethod(RND_ARR);
        assertTrue(isArrSorted(actual));
        assertEquals(RND_ARR.length, actual.length);
        assertEquals(sum(RND_ARR), sum(actual));

    }

    public boolean isArrSorted(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public double sum(Integer[] arr) {
        return Arrays.stream(arr).mapToDouble(integer -> integer).sum();
    }
}