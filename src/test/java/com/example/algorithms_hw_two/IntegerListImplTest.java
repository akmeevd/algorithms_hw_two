package com.example.algorithms_hw_two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerListImplTest {
    private IntegerListImpl integers1;
    private IntegerListImpl integers2;

    @BeforeEach
    public void setUp() {
        integers1 = new IntegerListImpl(4);
        integers1.add(3);
        integers1.add(1);
        integers1.add(2);
        integers1.add(4);
        integers2 = new IntegerListImpl(4);
        integers2.add(3);
        integers2.add(1);
        integers2.add(2);
        integers2.add(4);
    }

    @Test
    public void addString() {
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void addByIndex() {
        integers1.add(1, 1);
        integers2.add(1, 1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void set() {
        integers1.set(1, 1);
        integers2.set(1, 1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void removeByIndex() {
        integers1.remove(1);
        integers2.remove(1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void removeByString() {
        integers1.remove(1);
        integers2.remove(1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void contains() {
        Assertions.assertEquals(integers1.contains(1), 0);
    }

    @Test
    public void indexOf() {
        Assertions.assertEquals(integers1.indexOf(1), 1);
    }

    @Test
    public void lastIndexOf() {
        Assertions.assertEquals(integers1.indexOf(1), 1);
    }

    @Test
    public void get() {
        Assertions.assertEquals(integers1.get(0), 3);
    }

    @Test
    public void equals() {
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void size() {
        Assertions.assertEquals(integers1.size(), integers2.size());
    }

    @Test
    public void isEmpty() {
        Assertions.assertFalse(integers1.isEmpty());
    }

    @Test
    public void clear() {
        integers1.clear();
        Assertions.assertTrue(integers1.isEmpty());
    }

    @Test
    public void toArray() {
        Integer [] integers1 = this.integers1.toArray();
        Integer[] integers2 = new Integer[4];
        integers2[0] = 3;
        integers2[1] = 1;
        integers2[2] = 2;
        integers2[3] = 4;
        Assertions.assertArrayEquals(integers1,integers2);
    }

    @Test
    public void toRandomArray() {
        Integer[] integers = new Integer[]{};
        integers = IntegerListImpl.toRandomArray();
        Assertions.assertTrue(integers.length > 0);
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodAdd() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> integers1.add(11, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodAdd() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> integers1.add(3, null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> integers1.add(null));
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenUseMethodSet() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> integers1.set(5, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodSet() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> integers1.set(1, null));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodRemove() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> integers1.remove(null));
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodContains() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> integers1.contains(null));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenUseMethodEquals() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> integers1.equals(null));
    }
}
