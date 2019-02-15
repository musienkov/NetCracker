
import analyzer.Analyzer;
import output.Output;
import fillers.Fillers;

import java.util.Arrays;

/**
 * The main class
 *
 * @author Musienko
 */

public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <=10 ; i++) {
            Analyzer.analyzer(i);
        }

        Output output = new Output();
        output.write();


       /* for (int i = 1; i <=100 ; i*=10) {
            System.out.println(Arrays.toString(Fillers.createSortedArray(i)));
            System.out.println(Arrays.toString( Fillers.createUnsortedArray(i)));
            System.out.println(Arrays.toString( Fillers.createSortedWithRandom(i)));
            System.out.println(Arrays.toString( Fillers.createReversSortedArray(i)));


        }*/

    }
}
