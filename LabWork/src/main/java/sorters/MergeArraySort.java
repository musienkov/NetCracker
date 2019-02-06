package sorters;

/**
 * This class realizes merge sort using Arrays.sort()
 * @author Musienko
 */

public class MergeArraySort extends Merge {

    private ArraysSorter arraysSorter = new ArraysSorter();
    /**
     * Sorts arrays using merge sort with Array.sort(int[] arr)
     * @param arr - started array
     * @return sorted array
     * @see ArraysSorter#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    public int[] sort(int[] arr) {
        int L[] = super.createLeftPart(arr);
        int R[] = super.createRightPart(arr);
        arraysSorter.sort(L);
        arraysSorter.sort(R);
        return merge(arr, L, R);
    }
}
