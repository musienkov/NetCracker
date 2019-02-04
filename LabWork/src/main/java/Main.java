/**
 * The main class
 *
 * @author Musienko
 */

import analyzer.Analyzer;
import fillers.Filler;
import fillers.Fillers;
import sorters.Merge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {








        System.out.println("Subclasses:");
        //Analyzer.findSubclasses();
        Analyzer.analyzer();
    }

}
