package graph.util;

import java.lang.reflect.InvocationTargetException;

public class ClassCreator<T> {
    public T createInstance(Class<? extends T> clazz, Object... constructorArgs) {
        try {
            Class<?> loadedClazz = Class.forName(clazz.getName());

            Class<?>[] params = new Class[constructorArgs.length];

            for (int i = 0; i < params.length; i++) {
                params[i] = constructorArgs[i].getClass();
            }

            return (T) loadedClazz.getConstructor(params).newInstance(constructorArgs);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public T createInstance(Class<? extends T> clazz) {
        try {
            Class<?> loadedClazz = Class.forName(clazz.getName());

            return (T) loadedClazz.newInstance();

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
