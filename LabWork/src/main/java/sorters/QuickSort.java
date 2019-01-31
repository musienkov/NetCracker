package sorters;

/**
 * This class sorts array using a Quick sort
 */
public class QuickSort extends AbstractSorter {
    /**
     * Start method for quick sort
     * @param arr - started array
     * @return sorted array
     */
    public int[] sort(int arr[]) {

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * Sorting array using Quick sort
     * @param arr - started array
     * @param low - low point
     * @param high - high point
     * @return sorted array
     */
    private int[] quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;

    }

    /**
     * Find pivot
     * @param arr - current array
     * @param low - low point
     * @param high - high point
     * @return index of pivot
     */
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

