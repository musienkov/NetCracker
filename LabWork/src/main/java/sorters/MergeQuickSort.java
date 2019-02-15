package sorters;

import java.util.Arrays;

/**
 * This class realizes merge sort <br> using QuickSort
 *
 * @author Musienko
 */
public class MergeQuickSort extends Merge {

    private QuickSort quickSort = new QuickSort();

    /**
     * Sorts arrays using merge sort with Quick sort
     *
     * @param array - started array
     * @return sorted array
     * @see QuickSort#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     * See also  {@link Merge#createLeftPart(int[])}
     * See also  {@link Merge#createRightPart(int[])}
     */
    public int[] sort(int[] array) {

        int[] leftPart = super.createLeftPart(array);
        int[] rightPart = super.createRightPart(array);
        quickSort.sort(leftPart);
        quickSort.sort(rightPart);

        return merge(array, leftPart, rightPart);
    }
}
