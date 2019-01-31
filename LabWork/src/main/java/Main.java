/**
 * The main class
 *
 * @author Musienko
 */

import analyzer.Analyzer;
import fillers.Filler;
import fillers.Fillers;
import sorters.Merge;

import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Method> annotiedMethods = Analyzer.getMethodsAnnotatedWith(Fillers.class, Filler.class);
        for (Method m : annotiedMethods
        ) {
            System.out.println(m.getName());
        }

        System.out.println("Subclasses:");
        Analyzer.findSubclasses();
    }

}
