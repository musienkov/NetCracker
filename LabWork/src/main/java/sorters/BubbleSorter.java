
package sorters;

/**
 * Abstract class Bubble Sorter
 *
 * @author Musienko
 */
public abstract class BubbleSorter extends AbstractSorter {
    /**
     * Sorts array
     *
     * @param array - started array
     * @return arrat
     */
    public abstract int[] sort(int[] array);

    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
