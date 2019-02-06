
package sorters;

import java.util.Arrays;

/**
 * This class realizes Merge sort using Half division using variable types of sorters
 * @author Musienko
 *
 */
public abstract class Merge extends AbstractSorter {

    /**
     * This method combines two sorted arrays
     * @param arr - current array
     * @param L - left part of array
     * @param R - right part of array
     * @return sorted merged array
     */
     int[] merge(int arr[], int[] L, int[] R) {


        int n1 = L.length;
        int n2 = R.length;
        int i = 0, j = 0;

        int k = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return arr;
    }

    /**
     * Create left part of array
     * @param arr - started array
     * @return array
     */
    int[] createLeftPart(int[] arr) {
        int l = 0;
        int r = arr.length;
        int m = (l + r) / 2;
        return Arrays.copyOfRange(arr, l, m);
    }
    /**
     * Create Right part of array
     * @param arr - started array
     * @return array
     */
     int[] createRightPart(int[] arr) {
        int l = 0;
        int r = arr.length;
        int m = (l + r) / 2;

        return Arrays.copyOfRange(arr, m, r);
    }


    @Override
    public abstract int[] sort(int[] array);

}
