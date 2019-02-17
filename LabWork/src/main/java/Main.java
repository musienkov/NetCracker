
import analyzer.Analyzer;
import output.Output;

/**
 * The main class
 *
 * @author Musienko
 */

public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <=10000 ; i*=10) {
        Analyzer.analyzer(i);
       }
        Output output = new Output();
        output.write();
    }
}
