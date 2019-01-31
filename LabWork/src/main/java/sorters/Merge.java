/**
 * @author Musienko
 *
 */
package sorters;

import java.util.Arrays;

/**
 * This class realizes Merge sort using Half division using variable types of sorters
 */
public class Merge {
    private BubbleSorter bubbleSorter_start_to_end = new BubbleSortStartToEnd();
    private BubbleSorter bubbleSorter_end_to_start = new BubbleSortEndToStart();
    private ArraysSorter arraysSorter = new ArraysSorter();
    private QuickSort quickSort = new QuickSort();

    /**
     * This method combines two sorted arrays
     * @param arr - current array
     * @param L - left part of array
     * @param R - right part of array
     * @return sorted merged array
     */
    private int[] merge(int arr[], int[] L, int[] R) {


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
    private int[] createLeftPart(int[] arr) {
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
    private int[] createRightPart(int[] arr) {
        int l = 0;
        int r = arr.length;
        int m = (l + r) / 2;

        return Arrays.copyOfRange(arr, m, r);
    }

    /**
     * Sorts arrays using merge sort with Bubble sort sorting from start to end
     * @param arr - started array
     * @return sorted array
     */
    public int[] mergeBubbleSort_start_to_end(int[] arr) {

        int L[] = createLeftPart(arr);
        int R[] = createRightPart(arr);
        bubbleSorter_start_to_end.sort(L);
        bubbleSorter_start_to_end.sort(R);
        return merge(arr, L, R);
    }
    /**
     * Sorts arrays using merge sort with Bubble sort sorting from end to start
     * @param arr - started array
     * @return sorted array
     */
    public int[] mergeBubbleSort_end_to_start(int[] arr) {
        int L[] = createLeftPart(arr);
        int R[] = createRightPart(arr);
        bubbleSorter_end_to_start.sort(L);
        bubbleSorter_end_to_start.sort(R);
        return merge(arr, L, R);
    }
    /**
     * Sorts arrays using merge sort with Array.sort(int[] arr)
     * @param arr - started array
     * @return sorted array
     */
    public int[] mergeArraySort(int[] arr) {
        int L[] = createLeftPart(arr);
        int R[] = createRightPart(arr);
        arraysSorter.sort(L);
        arraysSorter.sort(R);
        return merge(arr, L, R);
    }
    /**
     * Sorts arrays using merge sort with Quick sort
     * @param arr - started array
     * @return sorted array
     */
    public int[] mergeQuickSort(int[] arr) {
        int L[] = createLeftPart(arr);
        int R[] = createRightPart(arr);
        quickSort.sort(L);
        quickSort.sort(R);
        return merge(arr, L, R);
    }
}
