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

    public static final Random RANDOM = new Random();

    private static void checkCorrectMinAndMax(int minValue, int maxValue) {
        if (minValue > maxValue || maxValue < 0 || minValue < 0) {
            throw new IllegalArgumentException(
                "Max value must be greater than or equal to Min value and both must be positive");
        }
    }

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
        Constructor<?> constructor = Arrays.stream(constructors).findFirst().orElseThrow();
        return generateObjectFromConstructor(constructor);
    }

    private <T> T generatePojo(Class<T> clazz)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> constructor = Arrays.stream(constructors)
            .filter(c -> Modifier.isPublic(c.getModifiers()))
            .findFirst().orElseThrow();
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
                int minValue = 0;
                int maxValue = 0;
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Min minAnnotation) {
                        minValue = minAnnotation.value();
                    }
                    if (annotation instanceof Max maxAnnotation) {
                        maxValue = maxAnnotation.value();
                    }
                }
                checkCorrectMinAndMax(minValue, maxValue);
                generatedValue = Math.max(minValue, Math.min(maxValue, (Integer) generatedValue));
            }

            args[i] = generatedValue;
        }
        return (T) constructor.newInstance(args);
    }

    boolean isNumeric(Class<?> type) {
        return type.isPrimitive() || Number.class.isAssignableFrom(type);
    }

    private Object generateRandomValue(Class<?> type) {
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return RANDOM.nextInt();
        }
        if (type.equals(double.class) || type.equals(Double.class)) {
            return RANDOM.nextDouble();
        }
        if (type.equals(String.class)) {
            return UUID.randomUUID().toString();
        }
        throw new RuntimeException("Unsupported type: " + type.getName());
    }
}
