/**
 * This class analyze performance rate of variable types of sorting and filling
 *
 * @author Musienko
 */

package analyzer;


import com.google.inject.Module;
import org.reflections.Reflections;
import sorters.AbstractSorter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Analyzer {
    /**
     * Find method marked by annotation
     *
     * @param type       - Class type
     * @param annotation - annotation which we are looking for
     * @return list of methods marked by annotation
     */


    public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<Method>();
        Class<?> klass = type;
        while (klass != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
            // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
            final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    Annotation Filler = method.getAnnotation(annotation);
                    // TODO process annotInstance
                    methods.add(method);
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            klass = klass.getSuperclass();
        }
        return methods;
    }


    public static void findSubclasses() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Reflections reflections = new Reflections("sorters");
        Set<Class<? extends AbstractSorter>> subTypes =
                reflections.getSubTypesOf(AbstractSorter.class);
        for (Class<?> c : subTypes
        ) {
            System.out.println(c.getName());
            Method[] methods = c.getMethods();
            for (Method method : methods) {


               if(method.getName().equals("sort")&&!(c.getName().equals("sorters.BubbleSorter"))&&!(c.getName().equals("sorters.Merge"))){

                    int[] array = new int[]{5,9,1,4};
                   Class<?> myClass = Class.forName(c.getName());
                   Object obj = myClass.newInstance();
                   String methodName = "";
                   methodName = "sort";
                   Method setNameMethod = obj.getClass().getMethod(methodName, int[].class);
                  setNameMethod.invoke(obj, array) ; // pass arg


                       System.out.println(Arrays.toString(array));



            }
            }
          //  Class[] params = new Class[] {Integer[].class};

          //  Method method = c.getMethod("sort", params);

        }
    }
}
