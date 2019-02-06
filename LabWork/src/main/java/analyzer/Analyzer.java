

package analyzer;

import fillers.Filler;
import fillers.Fillers;
import org.reflections.Reflections;
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
        ArrayList<Long> arrayTimes = new ArrayList();
        List<Method> fillerMethods = Analyzer.getMethodsAnnotatedWith(Fillers.class, Filler.class);
        Reflections reflections = new Reflections("sorters");
        Set<Class<? extends AbstractSorter>> subTypes = reflections.getSubTypesOf(AbstractSorter.class);
        for (Class<?> c : subTypes
        ) {
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                if (method.getName().equals("sort") && !(c.getName().equals("sorters.BubbleSorter")) && !(c.getName().equals("sorters.Merge"))) {
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

                        long startTime1 = System.nanoTime();
                        setNameMethod.invoke(sorterObject, myArray);
                        long sortTime1 = System.nanoTime() - startTime1;
                       
                    }
                }
            }
        }
    }
}
