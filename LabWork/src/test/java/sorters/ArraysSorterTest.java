package sorters;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysSorterTest {
    ArraysSorter arraysSorter = new ArraysSorter();
    @Test
    public void sort() throws Exception {
        //ArraysSorter arraysSorter = new ArraysSorter();
        int[] array = {5, 4, 222, 1};
        int[] actual = arraysSorter.sort(array);
        int[] expected = {1,4,5,222};
        assertArrayEquals(expected,actual);
        array = new int[]{-999999,1,-2};
        actual = arraysSorter.sort(array);
        expected = new int[]{-999999,-2,1};
        assertArrayEquals(expected,actual);

    }


    @Test(expected = NullPointerException.class)
    public void sortNull() {
        arraysSorter.sort(null);
    }



    @Test(timeout = 1)
    public void sortTime() {
        arraysSorter.sort(new int[]{4,5,6,8,1,222,3,4,8,9,1000,-19999,14});
    }
}