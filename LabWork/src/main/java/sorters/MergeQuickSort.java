package sorters;

public class MergeQuickSort extends Merge {

    private QuickSort quickSort = new QuickSort();
    /**
     * Sorts arrays using merge sort with Quick sort
     * @param arr - started array
     * @return sorted array
     */
    public int[] sort(int[] arr) {
        int L[] = super.createLeftPart(arr);
        int R[] = super.createRightPart(arr);
        quickSort.sort(L);
        quickSort.sort(R);
        return merge(arr, L, R);
    }
}
