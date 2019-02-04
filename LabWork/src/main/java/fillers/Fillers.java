/**
 * This class fills arrays in a few ways
 *
 * @author Musienko
 */
package fillers;

import java.util.Arrays;

public class Fillers {
    /**
     * Creates sorted array
     * @param length - size of array
     * @return sorted array
     */
    @Filler
    public static int[] createSortedArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(array);
        System.out.println("createSortedArray was invoked!");
        return array;
    }

    /**
     * Creates sorted array with a random element in the end
     * @param length - size of array
     * @return sorted array with a random element in the end
     */
    @Filler
    public static int[] createSortedWithRandom(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(array);
        array[length - 1] = (int) (Math.random() * 100);
        System.out.println("createSortedWithRandom was invoked!");
        return array;
    }
    /**
     * Creates reverse sorted array
     * @param length - size of array
     * @return reverse sorted array
     */
    @Filler
    public static int[] createReversSortedArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
        System.out.println("createReversSortedArray was invoked!");
        return array;
    }
    /**
     * Creates unsorted array filled by random elements
     * @param length - size of array
     * @return unsorted array filled by random elements
     */
    @Filler
    public static int[] createUnsortedArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("createUnsortedArray was invoked!");
        return array;
    }


}
