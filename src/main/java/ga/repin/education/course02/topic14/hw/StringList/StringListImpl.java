package ga.repin.education.course02.topic14.hw.StringList;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] elementData;
    private int size;
    private int capacity = 10;

    public StringListImpl() {
        this.elementData = new String[capacity];
    }

    public StringListImpl(int initialCapacity) {
        if (initialCapacity > 1) {
            this.capacity = initialCapacity;
            this.elementData = new String[this.capacity];
        } else {
            throw new StringListIllegalArgumentException("\nCapacity can't be less than 2" +
                    ", but: " +
                    this.capacity);
        }
    }

    @Override
    public String add(String item) {
        return add(this.size, item);
    }

    @Override
    public String add(int index, String item) {
        indexOf(item);
        get(index);
        if ((this.size + 2) < this.elementData.length) {
            if (index < this.size) {
                System.arraycopy(this.elementData, (index + 1), this.elementData,
                        index + 2, this.size - index);
            }
        } else {
            String[] temp = new String[(this.elementData.length * 2)];
            System.arraycopy(this.elementData, 0, temp, 0, (index + 1));
            if (index < this.size) {
                System.arraycopy(elementData, (index + 2), elementData,
                        index + 2, this.size - index);
            }
            this.elementData = temp;
        }
        this.elementData[(index + 1)] = item;
        this.size++;
        return item;
    }


    @Override
    public String set(int index, String item) {
        indexOf(item);
        get(index);
        get((index + 1));
        this.elementData[(index + 1)] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new StringListIllegalArgumentException("\nItem " + item + " is not found");
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        String item = get(index);
        get((index + 1));
        if (index != this.size) {
            System.arraycopy(elementData, (index + 2), elementData, (index + 1), this.size - index);
        }
        this.size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new StringListNullPointerException("\nHave not to be null");
        }

        for (int i = 1; i < (size + 1); i++) {
            if (elementData[i].equals(item)) {
                return (i - 1);
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new StringListNullPointerException("\nHave not to be null");
        }
        int j = 0; //индекс "с конца"
        for (int i = size; i > 0; i--) {

            if (elementData[i].equals(item)) {
                return j;
            }
            j++;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > this.size || index < 0) {
            throw new StringListIndexOutOfBoundsException("\nElement with index "
                    + index + " is unavailable.\nNumber of elements in array = " + size
                    + ".\nTotal size of array = " + elementData.length);
        }

        return elementData[(index + 1)];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        String[] temp = new String[(this.capacity)];
        elementData = temp;
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[this.size];
        System.arraycopy(elementData, 1, result, 0, this.size);
        return result;
    }

}
