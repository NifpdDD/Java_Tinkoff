package edu.hw10.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

class RandomObjectGenerator {
    public <T> T nextObject(Class<T> clazz) {
        try {
            if (clazz.isRecord()) {
                return generateRecord(clazz);
            }
                return generatePojo(clazz);

        } catch (Exception e) {
            throw new RuntimeException("Error generating random object", e);
        }
    }

    public <T> T nextObject(Class<T> clazz, String factoryMethodName) {
        try {
            Method factoryMethod = clazz.getMethod(factoryMethodName);
            return clazz.cast(factoryMethod.invoke(null));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error generating object with factory method", e);
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
        Object[] args = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            Annotation[] annotations = constructor.getParameterAnnotations()[i];

            Object generatedValue = generateRandomValue(parameterType);

            if (isNumeric(parameterType)) {
                for (Annotation annotation : annotations) {
                    int minValue = 0;
                    int maxValue = 0;
                    if (annotation instanceof Min) {
                        minValue = ((Min) annotation).value();
                        generatedValue = Math.max((Integer) generatedValue, minValue);
                    }
                    if (annotation instanceof Max) {
                        maxValue = ((Max) annotation).value();
                        generatedValue = Math.min((Integer) generatedValue, maxValue);
                    }
                    if (minValue > maxValue && maxValue > 0 && minValue > 0) {
                        throw new IllegalArgumentException("Max value must be greater than or equal to Min value");
                    }
                }
            }

            args[i] = generatedValue;
        }

        return (T) constructor.newInstance(args);
    }

    private boolean isNumeric(Class<?> type) {
        return Number.class.isAssignableFrom(type)
            || type == int.class || type == Integer.class
            || type == long.class || type == Long.class
            || type == float.class || type == Float.class
            ||

            type == double.class || type == Double.class;
    }

    private Object generateRandomValue(Class<?> type) {
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return new Random().nextInt();
        }
        if (type.equals(double.class) || type.equals(Double.class)) {
            return new Random().nextDouble();
        }
        if (type.equals(String.class)) {
            return UUID.randomUUID().toString();
        }
        throw new RuntimeException("Unsupported type: " + type.getName());
    }
}
