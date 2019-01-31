/**
 * @author Musienko
 *
 */
package sorters;

import java.util.Arrays;

/**
 * This class uses a standard sorting
 */
public class ArraysSorter extends AbstractSorter {
    /**
     * Sort array by standard sorting (Arrays.sort())
     * @param array - array that will be sorted
     * @return sorted array
     */
    public int[] sort(int[] array){
        Arrays.sort(array);
        return array;

    }
}
