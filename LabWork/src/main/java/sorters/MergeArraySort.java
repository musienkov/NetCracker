package sorters;

public class MergeArraySort extends Merge {

    private ArraysSorter arraysSorter = new ArraysSorter();
    /**
     * Sorts arrays using merge sort with Array.sort(int[] arr)
     * @param arr - started array
     * @return sorted array
     */
    public int[] sort(int[] arr) {
        int L[] = super.createLeftPart(arr);
        int R[] = super.createRightPart(arr);
        arraysSorter.sort(L);
        arraysSorter.sort(R);
        return merge(arr, L, R);
    }
}
