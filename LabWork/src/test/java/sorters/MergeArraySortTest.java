package sorters;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeArraySortTest {
    MergeArraySort mergeArraySort = new MergeArraySort();

    @Test
    public void sort() {

        int[] array = {5, 4, 222, 1};
        int[] actual = mergeArraySort.sort(array);
        int[] expected = {1, 4, 5, 222};
        assertArrayEquals(expected, actual);
        array = new int[]{-999999, 1, -2};
        actual = mergeArraySort.sort(array);
        expected = new int[]{-999999, -2, 1};
        assertArrayEquals(expected, actual);


    }

    @Test(expected = NullPointerException.class)
    public void sortNull() {
        mergeArraySort.sort(null);
    }

    @Test(timeout = 3)
    public void sortTime() {
        mergeArraySort.sort(new int[]{4, 5, 6, 8, 1, 222, 3, 4, 8, 9, 1000, -19999, 14, 20009, 2847, 0, 0, 0, 0, 0, 0});
    }
}