/**
 * @author Musienko
 *
 */
package sorters;

/**
 * Abstract class for two types of Bubble sort
 */
public abstract class BubbleSorter extends AbstractSorter {
    /**
     * Sorts array
     * @param array - started array
     * @return arrat
     */
    public abstract int[] sort(int[] array);
}
