package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Run {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        runTests(TestClass.class);
    }

    public static void runTests(Class<?> className) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Object object = className.newInstance();
        Method[] methods = className.getDeclaredMethods();
        TreeMap<Integer, Method> map = new TreeMap();
        int beforeCnt = 0, afterCnt = 0;
        int beforeIndx = -1, afterIndx = -1;

        for (int i = 0; i < methods.length; i++) {

            if (methods[i].getAnnotation(BeforeSuite.class) != null) {
                beforeCnt++;
                beforeIndx = i;
            }

            if (methods[i].getAnnotation(AfterSuite.class) != null) {
                afterCnt++;
                afterIndx = i;
            }

            if (beforeCnt > 1 || afterCnt > 1) {
                throw new RuntimeException("В классе" + className.getSimpleName() + "> 1 метода с аннотациями BeforeSuite/AfterSuite");
            }

            if (methods[i].getAnnotation(Test.class) != null) {
                map.put(methods[i].getAnnotation(Test.class).priority(), methods[i]);
            }
        }

        if (beforeIndx > -1) {
            methods[beforeIndx].invoke(object);
        }

        for (Map.Entry<Integer, Method> entry : map.entrySet()) {
            entry.getValue().invoke(object);
        }

        if (afterIndx > -1) {
            methods[afterIndx].invoke(object);
        }
    }

}
