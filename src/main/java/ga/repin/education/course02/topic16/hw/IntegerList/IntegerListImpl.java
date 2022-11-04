package ga.repin.education.course02.topic16.hw.IntegerList;

import java.util.Arrays;

import static ga.repin.education.course02.topic15.hw.IntegerList.SortMethods.selectionSortMethod;

public class IntegerListImpl implements IntegerList {

    private Integer[] elementData;
    private int size;
    private int capacity = 10;

    public IntegerListImpl() {
        elementData = new Integer[this.capacity];
    }

    public IntegerListImpl(int initialCapacity) {
        if (initialCapacity > 1) {
            this.capacity = initialCapacity;
            this.elementData = new Integer[this.capacity];
        } else {
            throw new IntegerListIllegalArgumentException("\nCapacity can't be less than 2" +
                    ", but: " +
                    this.capacity);
        }
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        increaseArray();
        elementData[size] = item;
        return elementData[size++];
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);

        if (index > this.size || index < 0) {
            throw new IntegerListIndexOutOfBoundsException("\nElement with index "
                    + index + " is unavailable.\nNumber of elements in array = " + this.size
                    + ".\nTotal size of array = " + elementData.length);
        }
        increaseArray();

        if (size - index >= 0) {
            System.arraycopy(elementData, index, elementData, index + 1,
                    size - index);
        }

        elementData[index] = item;
        size++;
        return elementData[index];
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new IntegerListNullPointerException("\nHave not to be null");
        }
    }

    private void increaseArray() {
        if (size == (elementData.length - 1)) {
            int newSize = elementData.length * 2 + 1;
            elementData = Arrays.copyOf(elementData, newSize);
        }
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        elementData[index] = item;
        return elementData[index];
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new IntegerListIllegalArgumentException("\nItem " + item + " is not found");
        }

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer element = elementData[index];

        if (size - index >= 0) {
            System.arraycopy(elementData, index + 1, elementData,
                    index, size - index);
        }

        size--;
        return element;
    }

    @Override
    public boolean contains(Integer item) {
        return binarySearch(selectionSortMethod(toArray()), item);
    }

    @Override
    public int indexOf(Integer item) {

        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int j = 0; //индекс "с конца"
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(item)) {
                return j;
            }
            j++;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return elementData[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size != otherList.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!elementData[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    private void validateIndex(int index) {
        try {
            if (elementData[index] == null || index >= size) {
                throw new IntegerListIndexOutOfBoundsException("\nElement with index "
                        + index + " is unavailable.\nNumber of elements in array = " + size
                        + ".\nTotal size of array = " + elementData.length);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IntegerListIndexOutOfBoundsException("\nElement with index "
                    + index + " is unavailable.\nNumber of elements in array = " + size
                    + ".\nTotal size of array = " + elementData.length);
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item.equals(arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
