package com.example.algorithms_hw_two;

import java.util.Arrays;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;

    public IntegerListImpl(Integer[] integerList) {
        this.integerList = integerList;
    }

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
    }

    public IntegerListImpl() {
        this.integerList = new Integer[10];
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == null) {
                integerList[i] = item;
                return item;
            }
        }return null;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkLength(index);
        checkItem(item);
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (i > index) {
                integerList[i] = integerList[i - 1];
            }
        }integerList[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkLength(index);
        checkItem(item);
        integerList[index] = item;
        return null;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (!integerList[i].equals(item)) {
                throw new IllegalArgumentException("нет такого значения в массиве");
            } else {
                integerList[i] = null;
                return item;
            }
        }return null;
    }

    @Override
    public Integer remove(int index) {
        checkLength(index);
        return integerList[index] = null;
    }

    @Override
    public int contains(Integer item) {
        checkItem(item);
        return IntegerListImpl.binarySearch(integerList,item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null || otherList.get(i) != null) {
                if (!integerList[i].equals(otherList.get(i))) {
                    return false;
                }
            }
        }return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) {
                factSize++;
            }
        }
        return factSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(integerList, null);
    }

    @Override
    public Integer[] toArray() {
        Integer [] integers = Arrays.copyOf(integerList, integerList.length);
        return integers;
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
    }

    private void checkLength(int index) {
        if (index > integerList.length) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                '}';
    }

    public static Integer[] toRandomArray() {
        Integer [] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }

    ///сортировка вставкой
    private static void sortInsertion(Integer[] integers) {
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }
    }


    ///Пузырьковая сортировка
    public static void sortBubble(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    swapElements(integers, j, j + 1);
                }
            }
        }
    }

    ///сортировка выбором
    public static void sortSelection(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int binarySearch(Integer[] integers, Integer item) {
        IntegerListImpl.sortInsertion(integers);
        return Arrays.binarySearch(integers, item);
    }

    public static void main(String[] args) {
        Integer[] integers1 = IntegerListImpl.toRandomArray();
        Integer[] integers2 = Arrays.copyOf(integers1, integers1.length);
        Integer[] integers3 = Arrays.copyOf(integers1, integers1.length);
        long start1 = System.currentTimeMillis();
        sortInsertion(integers1);
        System.out.println(System.currentTimeMillis() - start1);
        long start2 = System.currentTimeMillis();
        sortSelection(integers2);
        System.out.println(System.currentTimeMillis() - start2);
        long start3 = System.currentTimeMillis();
        sortBubble(integers3);
        System.out.println(System.currentTimeMillis() - start3);
    }
}
