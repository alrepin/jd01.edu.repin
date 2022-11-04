package ga.repin.education.course02.topic16.hw.IntegerList;

import ga.repin.education.course02.topic15.hw.IntegerList.IntegerList;
import ga.repin.education.course02.topic15.hw.IntegerList.IntegerListIllegalArgumentException;
import ga.repin.education.course02.topic15.hw.IntegerList.IntegerListImpl;
import ga.repin.education.course02.topic15.hw.IntegerList.IntegerListIndexOutOfBoundsException;
import ga.repin.education.course02.topic15.hw.IntegerList.IntegerListNullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    public static final Integer ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final Integer ITEM_3 = 3;
    public static final Integer ITEM_4 = 4;
    public static final Integer ITEM_5 = 5;
    public static final Integer NOT_ADDED_ITEM = 100;


    private ga.repin.education.course02.topic15.hw.IntegerList.IntegerList integerList;

    @BeforeEach
    public void setUp() {
        integerList = new ga.repin.education.course02.topic15.hw.IntegerList.IntegerListImpl();
        integerList.add(ITEM_2);
        integerList.add(ITEM_4);
    }

    @Test
    public void addItemsToEnd() {
        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {ITEM_2, ITEM_4});
    }

    @Test
    public void addItemsByIndex() {
        integerList.add(0, ITEM_1);
        integerList.add(2, ITEM_3);
        integerList.add(4, ITEM_5);

        assertThat(integerList.toArray())
                .isEqualTo(List.of(ITEM_1, ITEM_2, ITEM_3, ITEM_4, ITEM_5).toArray());
    }

    @Test
    public void addItemsByIndexException() {
        assertThatExceptionOfType(ga.repin.education.course02.topic15.hw.IntegerList.IntegerListIndexOutOfBoundsException.class)
                .isThrownBy(() -> integerList.add(3, ITEM_3));
    }

    @Test
    public void addNullItem() {
        assertThatExceptionOfType(ga.repin.education.course02.topic15.hw.IntegerList.IntegerListNullPointerException.class)
                .isThrownBy(() -> integerList.add(null))
                .withMessage("\nHave not to be null");

        assertThatExceptionOfType(ga.repin.education.course02.topic15.hw.IntegerList.IntegerListNullPointerException.class)
                .isThrownBy(() -> integerList.add(2, null))
                .withMessage("\nHave not to be null");
    }

    @Test
    public void setItem() {
        integerList.set(0, ITEM_1);
        integerList.set(1, ITEM_2);
        assertThat(integerList.toArray())
                .isEqualTo(List.of(ITEM_1, ITEM_2).toArray());
    }

    @Test
    public void setItemNegative() {
        assertThatExceptionOfType(IntegerListNullPointerException.class)
                .isThrownBy(() -> integerList.set(0, null))
                .withMessage("\nHave not to be null");

        assertThatExceptionOfType(IntegerListIndexOutOfBoundsException.class)
                .isThrownBy(() -> integerList.set(-5, NOT_ADDED_ITEM));
    }

    @Test
    public void removeByItem() {
        Integer actual = integerList.remove(ITEM_4);
        assertEquals(ITEM_4, actual);
        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {ITEM_2});
    }

    @Test
    public void removeByIndex() {
        integerList.remove(0);
        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {ITEM_4});
    }

    @Test
    public void removeByItemNegative() {
        assertThatExceptionOfType(IntegerListIllegalArgumentException.class)
                .isThrownBy(() -> integerList.remove(NOT_ADDED_ITEM));
    }

    @Test
    public void containOrNotContain() {
        assertFalse(integerList.contains(ITEM_1));
        Integer actual = integerList.add(ITEM_1);
        assertEquals(ITEM_1, actual);
        assertTrue(integerList.contains(ITEM_1));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(integerList.lastIndexOf(ITEM_4), 0);
        assertEquals(integerList.lastIndexOf(NOT_ADDED_ITEM), -1);
    }

    @Test
    public void getItem() {
        assertEquals(ITEM_2, integerList.get(0));
        assertEquals(ITEM_4, integerList.get(1));
    }

    @Test
    public void listEquals() {
        IntegerList s2 = new IntegerListImpl(20);
        s2.add(0,ITEM_1);
        s2.add(1,ITEM_2);
        s2.add(2,ITEM_3);
        assertFalse(integerList.equals(s2));
        integerList.add(0,ITEM_1);
        integerList.add(2,ITEM_3);
        integerList.remove(ITEM_4);
        assertTrue(integerList.equals(s2));
    }

    @Test
    public void sizeBeforeAndAfterClearing() {
        assertEquals(2, integerList.size());
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

}