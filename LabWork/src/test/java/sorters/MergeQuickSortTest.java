package sorters;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeQuickSortTest {
    MergeQuickSort mergeQuickSort = new MergeQuickSort();

    @Test
    public void sort()  {

        int[] array = {5, 4, 222, 1};
        int[] actual = mergeQuickSort.sort(array);
        int[] expected = {1, 4, 5, 222};
        assertArrayEquals(expected, actual);
        array = new int[]{-999999, 1, -2};
        actual = mergeQuickSort.sort(array);
        expected = new int[]{-999999, -2, 1};
        assertArrayEquals(expected, actual);
        array = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        actual = mergeQuickSort.sort(array);
        expected = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(expected,actual);

    }

    @Test(expected = NullPointerException.class)
    public void sortNull() {
        mergeQuickSort.sort(null);
    }

    @Test(timeout = 1)
    public void sortTime() {
        mergeQuickSort.sort(new int[]{14,-199999,2999,928,222,3,4,8,9,1000,-19999,14});
    }
}