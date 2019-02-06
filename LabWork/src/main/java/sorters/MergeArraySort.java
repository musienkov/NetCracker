package sorters;

/**
 * This class realizes merge sort <br> using Arrays.sort()
 * @author Musienko
 */

public class MergeArraySort extends Merge {

    private ArraysSorter arraysSorter = new ArraysSorter();
    /**
     * Sorts arrays using merge sort with Array.sort(int[] arr)
     * @param array - started array
     * @return sorted array
     * @see ArraysSorter#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    public int[] sort(int[] array) {
        int[] leftPart = super.createLeftPart(array);
        int[] rightPart = super.createRightPart(array);
        arraysSorter.sort(leftPart);
        arraysSorter.sort(rightPart);
        return merge(array, leftPart, rightPart);
    }
}
