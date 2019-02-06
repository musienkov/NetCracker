package sorters;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
QuickSort quickSort = new QuickSort();
    @Test
    public void sort()  {

        int[] array = {5, 4, 222, 1};
        int[] actual = quickSort.sort(array);
        int[] expected = {1,4,5,222};
        assertArrayEquals(expected,actual);
        array = new int[]{-999999,1,-2};
        actual = quickSort.sort(array);
        expected = new int[]{-999999,-2,1};
        assertArrayEquals(expected,actual);
        array = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        actual = quickSort.sort(array);
        expected = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(expected,actual);

    }
    @Test(expected = NullPointerException.class)
    public void sortNull() {
        quickSort.sort(null);
    }

    @Test(timeout = 1)
    public void sortTime() {
        quickSort.sort(new int[]{4,5,6,8,1,500,50,5000,29385,3849,-19});
    }
}