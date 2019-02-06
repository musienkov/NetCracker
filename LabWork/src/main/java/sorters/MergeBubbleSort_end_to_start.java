package sorters;
/**
 * This class realizes merge sort <br> using  BubbleSort from end to start
 * @author Musienko
 */
public class MergeBubbleSort_end_to_start extends Merge {

    private BubbleSorter bubbleSorter_end_to_start = new BubbleSortEndToStart();

    /**
     * Sorts arrays using merge sort with Bubble sort sorting from end to start
     * @param array - started array
     * @return sorted array
     * @see BubbleSortEndToStart#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    public int[] sort(int[] array) {
        int[] leftPart = super.createLeftPart(array);
        int[] rightPart = super.createRightPart(array);
        bubbleSorter_end_to_start.sort(leftPart);
        bubbleSorter_end_to_start.sort(rightPart);
        return merge(array, leftPart, rightPart);
    }
}
