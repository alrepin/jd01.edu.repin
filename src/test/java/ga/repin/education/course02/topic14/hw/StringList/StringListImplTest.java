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


    private final StringList s = new StringListImpl();

    @BeforeEach
    public void testItemsPrepare() {
        s.add(ITEM_2);
        s.add(ITEM_4);
    }

    @Test
    public void addItemsToEnd() {
        assertThat(s.toArray())
                .isEqualTo(new String[] {ITEM_2, ITEM_4});
    }

    @Test
    public void addItemsByIndex() {
        s.add(0, ITEM_1);
        s.add(2, ITEM_3);
        s.add(4, ITEM_5);

        assertThat(s.toArray())
                .isEqualTo(List.of(ITEM_1, ITEM_2, ITEM_3, ITEM_4, ITEM_5).toArray());
    }

    @Test
    public void addItemsByIndexException() {
        assertThatExceptionOfType(StringListIndexOutOfBoundsException.class)
                .isThrownBy(() -> s.add(3, ITEM_3));
    }

    @Test
    public void addNullItem() {
        assertThatExceptionOfType(StringListNullPointerException.class)
                .isThrownBy(() -> s.add(null))
                .withMessage("\nHave not to be null");

        assertThatExceptionOfType(StringListNullPointerException.class)
                .isThrownBy(() -> s.add(2, null))
                .withMessage("\nHave not to be null");
    }

    @Test
    public void setItem() {
        s.set(0, ITEM_1);
        s.set(1, ITEM_2);
        assertThat(s.toArray())
                .isEqualTo(List.of(ITEM_1, ITEM_2).toArray());
    }

    @Test
    public void setItemNegative() {
        assertThatExceptionOfType(StringListNullPointerException.class)
                .isThrownBy(() -> s.set(0, null))
                .withMessage("\nHave not to be null");

        assertThatExceptionOfType(StringListIndexOutOfBoundsException.class)
                .isThrownBy(() -> s.set(-5, NOT_ADDED_ITEM));
    }

    @Test
    public void removeByItem() {
        String actual = s.remove(ITEM_4);
        assertEquals(ITEM_4, actual);
        assertThat(s.toArray())
                .isEqualTo(new String[] {ITEM_2});
    }

    @Test
    public void removeByIndex() {
        s.remove(0);
        assertThat(s.toArray())
                .isEqualTo(new String[] {ITEM_4});
    }

    @Test
    public void removeByItemNegative() {
        assertThatExceptionOfType(StringListIllegalArgumentException.class)
                .isThrownBy(() -> s.remove(NOT_ADDED_ITEM));
    }

    @Test
    public void containOrNotContain() {
        assertFalse(s.contains(ITEM_1));
        String actual = s.add(ITEM_1);
        assertEquals(ITEM_1, actual);
        assertTrue(s.contains(ITEM_1));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(s.lastIndexOf(ITEM_4), 0);
        assertEquals(s.lastIndexOf(NOT_ADDED_ITEM), -1);
    }

    @Test
    public void getItem() {
        assertEquals(ITEM_2, s.get(0));
        assertEquals(ITEM_4, s.get(1));
    }

    @Test
    public void listEquals() {
        StringList s2 = new StringListImpl();
        s2.add(0,ITEM_1);
        s2.add(1,ITEM_2);
        s2.add(2,ITEM_3);
        assertFalse(s.equals(s2));
        s.add(0,ITEM_1);
        s.add(2,ITEM_3);
        s.remove(ITEM_4);
        assertTrue(s.equals(s2));
    }

    @Test
    public void sizeBeforeAndAfterClearing() {
        assertEquals(2, s.size());
        s.clear();
        assertTrue(s.isEmpty());
    }

}