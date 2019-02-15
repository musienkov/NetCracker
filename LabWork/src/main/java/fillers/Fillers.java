
package fillers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * This class fills arrays in a few ways
 *
 * @author Musienko
 */
public class Fillers {
    /**
     * Creates sorted array
     *
     * @param length - size of array
     * @return sorted array
     */
    @Filler
    public static int[] createSortedArray(int length) {

       Random random = new Random();
        int[] array = new int[length];
        array[0] = 1;
        for (int i = 1; i < length; i++) {
            array[i] = array[i - 1] + random.nextInt(10);
        }
        return array;
    }

    /**
     * Creates sorted array with a random element in the end
     *
     * @param length - size of array
     * @return sorted array with a random element in the end
     */
    @Filler
    public static int[] createSortedWithRandom(int length) {

        int[] array = createSortedArray(length);

        array[length-1] = (int)(Math.random()*50);
        System.out.println("Filler: "+Arrays.toString(array));
        return array;
    }

    /**
     * Creates reverse sorted array
     *
     * @param length - size of array
     * @return reverse sorted array
     */
    @Filler
    public static int[] createReversSortedArray(int length) {
        int[] array = createSortedArray(length);
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
        return array;
    }

    /**
     * Creates unsorted array filled by random elements
     *
     * @param length - size of array
     * @return unsorted array filled by random elements
     */
    @Filler
    public static int[] createUnsortedArray(int length) {
        int[] array = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                array[i] = (int) (Math.random() * 100);
            }
        }
        return array;
    }


}
