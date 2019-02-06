package sorters;
/**
 * This class realizes merge sort using QuickSort
 * @author Musienko
 */
public class MergeQuickSort extends Merge {

    private QuickSort quickSort = new QuickSort();
    /**
     * Sorts arrays using merge sort with Quick sort
     * @param arr - started array
     * @return sorted array
     * @see QuickSort#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     * See also  {@link Merge#createLeftPart(int[])}
     * See also  {@link Merge#createRightPart(int[])}
     */
    public int[] sort(int[] arr) {
        int L[] = super.createLeftPart(arr);
        int R[] = super.createRightPart(arr);
        quickSort.sort(L);
        quickSort.sort(R);
        return merge(arr, L, R);
    }
}
