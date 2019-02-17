package sorters;


/**
 * <h1>QuickSort</h1>
 * <p>This class sorts array using a Quick sort</p>
 *
 * @author Musienko
 */
public class QuickSort extends AbstractSorter {
    /**
     * Start method for quick sort
     *
     * @param array - started array
     * @return sorted array
     */
    public int[] sort(int[] array) {

        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Sorting array using Quick sort
     *
     * @param array - started array
     * @param low   - low point
     * @param high  - high point
     * @return sorted array
     * See also {@link QuickSort#partition(int[], int, int)}
     */
    private int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        return array;

    }

    /**
     * Find pivot
     *
     * @param array - current array
     * @param low   - low point
     * @param high  - high point
     * @return index of pivot {@link QuickSort#quickSort(int[], int, int)}
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}

