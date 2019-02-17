
package sorters;

import java.util.Arrays;

/**
 * <h1>ArraysSorter</h1>
 * <p>This class realizes sorting the array using Arrays.sort().</p>
 *
 * @author Musienko
 */
public class ArraysSorter extends AbstractSorter {
    /**
     * Sort array by standard sorting (Arrays.sort())
     *
     * @param array - array that will be sorted
     * @return sorted array
     */
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;

    }
}
