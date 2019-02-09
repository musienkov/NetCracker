/**
 * The main class
 *
 * @author Musienko
 */

import analyzer.Analyzer;
import fillers.Filler;
import fillers.Fillers;
import org.apache.poi.sl.usermodel.Sheet;
import output.Output;
import output.TestClass;
import sorters.Merge;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Analyzer.analyzer2(10);
        Analyzer.analyzer2(20);
        Analyzer.analyzer2(30);
        Output output = new Output();
        output.write();
        //TestClass test = new TestClass();
       // test.test();



    }

}
