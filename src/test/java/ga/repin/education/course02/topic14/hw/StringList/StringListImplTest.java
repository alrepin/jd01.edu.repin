package ga.repin.education.course02.topic14.hw.StringList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    public static final String ITEM_1 = "One";
    public static final String ITEM_2 = "Two";
    public static final String ITEM_3 = "Three";
    public static final String ITEM_4 = "Fore";
    public static final String ITEM_5 = "Five";
    public static final String NOT_ADDED_ITEM = "Abrakadabra";


    private StringList stringList;

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl();
        stringList.add(ITEM_2);
        stringList.add(ITEM_4);
    }

    @Test
    public void addItemsToEnd() {
        assertThat(stringList.toArray())
                .isEqualTo(new String[] {ITEM_2, ITEM_4});
    }

    @Test
    public void addItemsByIndex() {
        stringList.add(0, ITEM_1);
        stringList.add(2, ITEM_3);
        stringList.add(4, ITEM_5);

        assertThat(stringList.toArray())
                .isEqualTo(List.of(ITEM_1, ITEM_2, ITEM_3, ITEM_4, ITEM_5).toArray());
    }

    @Test
    public void addItemsByIndexException() {
        assertThatExceptionOfType(StringListIndexOutOfBoundsException.class)
                .isThrownBy(() -> stringList.add(3, ITEM_3));
    }

    @Test
    public void addNullItem() {
        assertThatExceptionOfType(StringListNullPointerException.class)
                .isThrownBy(() -> stringList.add(null))
                .withMessage("\nHave not to be null");

        assertThatExceptionOfType(StringListNullPointerException.class)
                .isThrownBy(() -> stringList.add(2, null))
                .withMessage("\nHave not to be null");
    }

    @Test
    public void setItem() {
        stringList.set(0, ITEM_1);
        stringList.set(1, ITEM_2);
        assertThat(stringList.toArray())
                .isEqualTo(List.of(ITEM_1, ITEM_2).toArray());
    }

    @Test
    public void setItemNegative() {
        assertThatExceptionOfType(StringListNullPointerException.class)
                .isThrownBy(() -> stringList.set(0, null))
                .withMessage("\nHave not to be null");

        assertThatExceptionOfType(StringListIndexOutOfBoundsException.class)
                .isThrownBy(() -> stringList.set(-5, NOT_ADDED_ITEM));
    }

    @Test
    public void removeByItem() {
        String actual = stringList.remove(ITEM_4);
        assertEquals(ITEM_4, actual);
        assertThat(stringList.toArray())
                .isEqualTo(new String[] {ITEM_2});
    }

    @Test
    public void removeByIndex() {
        stringList.remove(0);
        assertThat(stringList.toArray())
                .isEqualTo(new String[] {ITEM_4});
    }

    @Test
    public void removeByItemNegative() {
        assertThatExceptionOfType(StringListIllegalArgumentException.class)
                .isThrownBy(() -> stringList.remove(NOT_ADDED_ITEM));
    }

    @Test
    public void containOrNotContain() {
        assertFalse(stringList.contains(ITEM_1));
        String actual = stringList.add(ITEM_1);
        assertEquals(ITEM_1, actual);
        assertTrue(stringList.contains(ITEM_1));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(stringList.lastIndexOf(ITEM_4), 0);
        assertEquals(stringList.lastIndexOf(NOT_ADDED_ITEM), -1);
    }

    @Test
    public void getItem() {
        assertEquals(ITEM_2, stringList.get(0));
        assertEquals(ITEM_4, stringList.get(1));
    }

    @Test
    public void listEquals() {
        StringList s2 = new StringListImpl();
        s2.add(0,ITEM_1);
        s2.add(1,ITEM_2);
        s2.add(2,ITEM_3);
        assertFalse(stringList.equals(s2));
        stringList.add(0,ITEM_1);
        stringList.add(2,ITEM_3);
        stringList.remove(ITEM_4);
        assertTrue(stringList.equals(s2));
    }

    @Test
    public void sizeBeforeAndAfterClearing() {
        assertEquals(2, stringList.size());
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

}