

package analyzer;

import fillers.Filler;
import fillers.Fillers;
import org.reflections.Reflections;
import output.Output;
import sorters.AbstractSorter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * This class analyze performance rate of variable types of sorting and filling
 *
 * @author Musienko
 */
public class Analyzer {

    ArrayList<Long> arrayTimes = new ArrayList();
    private static Reflections reflections = new Reflections("sorters");
    private static Set<Class<? extends AbstractSorter>> subTypes = reflections.getSubTypesOf(AbstractSorter.class);
    private static List<Method> fillerMethods = Analyzer.getMethodsAnnotatedWith(Fillers.class, Filler.class);
    private static List<Integer> sizesList = new ArrayList<>();
    /**
     * Find method marked by annotation
     *
     * @param type       - Class type
     * @param annotation - annotation which we are looking for
     * @return list of methods marked by annotation
     */

    private static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<Method>();
        Class<?> klass = type;
        while (klass != Object.class) {

            final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    Annotation Filler = method.getAnnotation(annotation);

                    methods.add(method);
                }
            }

            klass = klass.getSuperclass();
        }
        return methods;
    }

    /**
     * Automatic analyzer of all sorts and all fillers
     *
     * @param arrayLength - length of array
     */
    public static void analyzer(int arrayLength) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        sizesList.add(arrayLength);


        for (Class<?> c : subTypes
        ) {
            if(!(c.getName().equals("sorters.BubbleSorter")) && !(c.getName().equals("sorters.Merge"))) {
                System.out.println("Class: " + c.getName());
                Method[] methods = c.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals("sort") ) {
                        for (Method m : fillerMethods
                        ) {
                            Class<?> myFiller = Class.forName(m.getDeclaringClass().getName());
                            Object fillerObject = myFiller.newInstance();
                            String fillerName;
                            fillerName = m.getName();
                            Method setFillerMethod = fillerObject.getClass().getMethod(fillerName, int.class);
                            int[] myArray = (int[]) setFillerMethod.invoke(fillerObject, arrayLength);
                            Class<?> myClass = Class.forName(c.getName());
                            Object sorterObject = myClass.newInstance();
                            Method setNameMethod = sorterObject.getClass().getMethod("sort", int[].class);
                            System.out.println("Filler: " + m.getName());
                            long startTime1 = System.nanoTime();
                            setNameMethod.invoke(sorterObject, myArray);
                            long sortTime1 = System.nanoTime() - startTime1;

                        }
                    }
                }
            }
        }
    }

    public static void analyzer2(int arrayLength) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        sizesList.add(arrayLength);

        ArrayList<Long> times = new ArrayList<>();
        for (Method m : fillerMethods
        ) {
            Class<?> myFiller = Class.forName(m.getDeclaringClass().getName());
            Object fillerObject = myFiller.newInstance();
            String fillerName;
            fillerName = m.getName();
            Method setFillerMethod = fillerObject.getClass().getMethod(fillerName, int.class);
            int[] myArray = (int[]) setFillerMethod.invoke(fillerObject, arrayLength);
            System.out.println("Filler: " + m.getName());

            for (Class<?> c:subTypes
                 ) {
                if (!(c.getName().equals("sorters.BubbleSorter")) && !(c.getName().equals("sorters.Merge"))) {

                    Method[] methods = c.getMethods();
                    for (Method method : methods) {
                        if (method.getName().equals("sort")) {

                            Class<?> myClass = Class.forName(c.getName());
                            Object sorterObject = myClass.newInstance();
                            Method setNameMethod = sorterObject.getClass().getMethod("sort", int[].class);
                            System.out.print("Class: " + c.getName());
                            long startTime = System.nanoTime();
                            setNameMethod.invoke(sorterObject, myArray);
                            long sortTime = System.nanoTime() - startTime;
                            System.out.println(" = "+sortTime);
                            times.add(sortTime);


                        }
                    }

                }


            }
            Output.fillMap(arrayLength,m.getName(),times);
            times.clear();

        }

    }
    public static List<String> getNamesOfSubclasses(){
        List<String> namesOfSubclasses = new ArrayList<>();
        for (Class<?> c:subTypes
        ) {
            if(!(c.getName().equals("sorters.BubbleSorter")) && !(c.getName().equals("sorters.Merge")))
                namesOfSubclasses.add(c.getName());

        }
        return namesOfSubclasses;
    }

    private static void setDataForOutput(){


    }



}
