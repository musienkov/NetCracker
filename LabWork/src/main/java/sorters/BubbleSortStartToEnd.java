
package sorters;

/**
 * This class realizes sorting the array using BubbleSort from Start To End
 * @author Musienko
 */

public class BubbleSortStartToEnd extends BubbleSorter {
    /**
     * Sorts array using Bubble sort from start to end
     * @param array - array that will be sorted
     * @return sorted array
     * @see BubbleSorter
     */
    public int[] sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array,j,j+1);
                }
            }
        return array;
    }
}
