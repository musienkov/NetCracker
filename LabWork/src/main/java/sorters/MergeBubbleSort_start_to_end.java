package sorters;

/**
 * This class realizes merge sort <br> using BubbleSort from start to end
 * @author Musienko
 */
public class MergeBubbleSort_start_to_end extends Merge{

    private BubbleSorter bubbleSorter_start_to_end = new BubbleSortStartToEnd();
    /**
     * Sorts arrays using merge sort with Bubble sort sorting from start to end
     * @param array - started array
     * @return sorted array
     * @see BubbleSortStartToEnd#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    public int[] sort(int[] array) {

        int[] leftPart = super.createLeftPart(array);
        int[] rightPart = super.createRightPart(array);
        bubbleSorter_start_to_end.sort(leftPart);
        bubbleSorter_start_to_end.sort(rightPart);
        return merge(array, leftPart, rightPart);
    }
}
