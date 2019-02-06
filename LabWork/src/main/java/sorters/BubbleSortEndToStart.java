
package sorters;

/**
 * This class realizes sorting the array using BubbleSort from End To Start
 * @author Musienko
 */
public class BubbleSortEndToStart extends BubbleSorter {
    /**
     *
     * @param array - array that will be sorted
     * @return  sorted array
     */
    public int[] sort(int[] array) {

        int n = array.length;
        for (int i = array.length - 1; i >= 0; i--)
            for (int j = array.length - 1; j >= n - i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array,j,j-1);
                }
            }
        return array;
    }
}
