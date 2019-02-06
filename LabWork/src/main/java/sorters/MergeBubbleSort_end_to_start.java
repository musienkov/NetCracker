package sorters;
/**
 * This class realizes merge sort using BubbleSort from end to start
 * @author Musienko
 */
public class MergeBubbleSort_end_to_start extends Merge {

    private BubbleSorter bubbleSorter_end_to_start = new BubbleSortEndToStart();

    /**
     * Sorts arrays using merge sort with Bubble sort sorting from end to start
     * @param arr - started array
     * @return sorted array
     * @see BubbleSortEndToStart#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    public int[] sort(int[] arr) {
        int L[] = super.createLeftPart(arr);
        int R[] = super.createRightPart(arr);
        bubbleSorter_end_to_start.sort(L);
        bubbleSorter_end_to_start.sort(R);
        return merge(arr, L, R);
    }
}
