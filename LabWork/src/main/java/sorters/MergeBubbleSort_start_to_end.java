package sorters;

/**
 * This class realizes merge sort using BubbleSort from start to end
 * @author Musienko
 */
public class MergeBubbleSort_start_to_end extends Merge{

    private BubbleSorter bubbleSorter_start_to_end = new BubbleSortStartToEnd();
    /**
     * Sorts arrays using merge sort with Bubble sort sorting from start to end
     * @param arr - started array
     * @return sorted array
     * @see BubbleSortStartToEnd#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    public int[] sort(int[] arr) {

        int L[] = super.createLeftPart(arr);
        int R[] = super.createRightPart(arr);
        bubbleSorter_start_to_end.sort(L);
        bubbleSorter_start_to_end.sort(R);
        return merge(arr, L, R);
    }
}
