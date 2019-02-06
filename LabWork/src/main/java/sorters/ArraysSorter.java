
package sorters;

import java.util.Arrays;

/**
 * This class realizes sorting the array <br> using Arrays.sort().
 * @author Musienko
 *
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
