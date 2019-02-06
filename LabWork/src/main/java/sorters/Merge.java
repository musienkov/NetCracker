
package sorters;

import java.util.Arrays;

/**
 * This class realizes Merge sort <br> using Half division using variable types of sorters
 *
 * @author Musienko
 */
public abstract class Merge extends AbstractSorter {

    /**
     * This method combines two sorted arrays
     *
     * @param array     - current array
     * @param leftPart  - left part of array
     * @param rightPart - right part of array
     * @return sorted merged array
     */
    int[] merge(int array[], int[] leftPart, int[] rightPart) {


        int n1 = leftPart.length;
        int n2 = rightPart.length;
        int i = 0, j = 0;

        int k = 0;
        while (i < n1 && j < n2) {
            if (leftPart[i] <= rightPart[j]) {
                array[k] = leftPart[i];
                i++;
            } else {
                array[k] = rightPart[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            array[k] = leftPart[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightPart[j];
            j++;
            k++;
        }
        return array;
    }

    /**
     * Create left part of array
     *
     * @param array - started array
     * @return array
     */
    int[] createLeftPart(int[] array) {
        int left = 0;
        int right = array.length;
        int mid = (left + right) / 2;
        return Arrays.copyOfRange(array, left, mid);
    }

    /**
     * Create Right part of array
     *
     * @param array - started array
     * @return array
     */
    int[] createRightPart(int[] array) {
        int left = 0;
        int right = array.length;
        int mid = (left + right) / 2;

        return Arrays.copyOfRange(array, mid, right);
    }


    @Override
    public abstract int[] sort(int[] array);

}
