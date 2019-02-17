package sorters;

/**<h1>MergeArraySort</h1>
 * <p>This class realizes merge sort using Arrays.sort()</p>
 *
 * @author Musienko
 */

public class MergeArraySort extends Merge implements Runnable {
    private int[] array;
    private int recursiveLevel;
    private int[] sortedArray;

    private ArraysSorter arraysSorter = new ArraysSorter();

    public MergeArraySort() {
    }

    public MergeArraySort(int[] array, int recursiveLevel, int[] sortedArray) {
        this.array = array;
        this.recursiveLevel = recursiveLevel;
        this.sortedArray = sortedArray;
    }

    /**
     * Sorts arrays using merge sort with Array.sort(int[] arr)
     *
     * @param array - started array
     * @return sorted array
     * @see ArraysSorter#sort(int[])
     * @see Merge#merge(int[], int[], int[])
     */
    @Override
    public int[] sort(int[] array) {
        this.sortedArray = new int[array.length];
        try {
            parallelMergeSort(array, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = this.sortedArray[i];
        }


        return array;
    }

    /**
     * Merge sort which in parallel sorts the parts of the array in different threads
     * @param array
     * @param recursiveLevel
     * @throws InterruptedException
     */

    private void parallelMergeSort(int[] array, int recursiveLevel) throws InterruptedException {
        long threadCount = Math.round(-(1 - Math.pow(2, recursiveLevel)));
        if (Runtime.getRuntime().availableProcessors() > threadCount) {
            recursiveLevel++;
            int[] leftPart = createLeftPart(array);
            int[] rightPart = createRightPart(array);
            int[] sortedLeft = new int[leftPart.length];
            int[] sortedRight = new int[rightPart.length];
            Runnable runnable1 = new MergeArraySort(leftPart, recursiveLevel, sortedLeft);
            Runnable runnable2 = new MergeArraySort(rightPart, recursiveLevel, sortedRight);
            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            int[] tempArray = merge(array, sortedLeft, sortedRight);
            for (int i = 0; i < tempArray.length; i++) {
                this.sortedArray[i] = tempArray[i];
            }
         }
         else {
            int[] tempArray = arraysSorter.sort(array);
            for (int i = 0; i < tempArray.length; i++) {
                this.sortedArray[i] = tempArray[i];
            }

        }
    }
    @Override
    public void run() {
        try {
            parallelMergeSort(array, recursiveLevel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}