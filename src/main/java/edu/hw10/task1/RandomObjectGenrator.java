package edu.hw10.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

class RandomObjectGenerator {
    public <T> T nextObject(Class<T> clazz) {
        try {
            if (clazz.isRecord()) {
                return generateRecord(clazz);
            } else {
                return generatePojo(clazz);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error generating random object", e);
        }
    }

    private <T> T generateRecord(Class<T> clazz)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> constructor = Arrays.stream(constructors).findFirst().orElse(null);
        if (constructor == null) {
            throw new RuntimeException("No constructors found for record: " + clazz.getName());
        }

        return generateObjectFromConstructor(constructor);
    }

    private <T> T generatePojo(Class<T> clazz)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> constructor = Arrays.stream(constructors)
            .filter(c -> Modifier.isPublic(c.getModifiers()))
            .findFirst()
            .orElse(null);

        if (constructor == null) {
            throw new RuntimeException("No public constructors found for class: " + clazz.getName());
        }

        return generateObjectFromConstructor(constructor);
    }

    private <T> T generateObjectFromConstructor(Constructor<?> constructor)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] args = Arrays.stream(parameterTypes)
            .map(this::generateRandomValue)
            .toArray();

        return (T) constructor.newInstance(args);
    }

    private Object generateRandomValue(Class<?> type) {
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return new Random().nextInt();
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return new Random().nextDouble();
        } else if (type.equals(String.class)) {
            return UUID.randomUUID().toString();
        } else {
            throw new RuntimeException("Unsupported type: " + type.getName());
        }
    }
}
