package fillers;

import org.junit.Test;

import static org.junit.Assert.*;

public class FillersTest {

    @Test(expected = NegativeArraySizeException.class)
    public void createSortedArrayNegativeSize() {

        Fillers.createSortedArray(-1);

    }

    @Test(expected = NegativeArraySizeException.class)
    public void createSortedWithRandomNegativeSize() {

        Fillers.createSortedWithRandom(-111);

    }

    @Test(expected = NegativeArraySizeException.class)
    public void createReversSortedArrayNegativeSize() {

        Fillers.createReversSortedArray(-13);

    }

    @Test(expected = NegativeArraySizeException.class)
    public void createUnsortedArrayNegativeSize() {

        Fillers.createUnsortedArray(-12);

    }


    @Test(timeout = 5)
    public void createSortedArrayTime() {
        Fillers.createSortedArray(100);
    }

    @Test(timeout = 10)
    public void createSortedWithRandomTime() {
        Fillers.createSortedWithRandom(100);
    }

    @Test(timeout = 5)
    public void createReversSortedArrayTime() {
        Fillers.createReversSortedArray(100);
    }

    @Test(timeout = 5)
    public void createUnsortedArrayTime() {
        Fillers.createUnsortedArray(100);
    }


    @Test
    public void createSortedArray() {
        int[] array = Fillers.createSortedArray(5);
        boolean expected = true;
        boolean actual = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] >= array[i]) actual = true;
            else {
                actual = false;
                break;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void createSortedWithRandom() {
        int[] array = Fillers.createSortedWithRandom(5);
        boolean expected = true;
        boolean actual = false;
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i + 1] >= array[i]) actual = true;
            else {
                actual = false;
                break;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void createReversSortedArray() {
        int[] array = Fillers.createReversSortedArray(5);
        boolean expected = true;
        boolean actual = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] <= array[i]) actual = true;
            else {
                actual = false;
                break;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void createUnsortedArray() {
    }
}