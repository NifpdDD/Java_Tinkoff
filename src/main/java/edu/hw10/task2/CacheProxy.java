package edu.hw10.task2;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
public class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<Method, Map<Integer, Long>> cache;
    private final String cacheDirectory;

    private CacheProxy(Object target, String cacheDirectory) {
        this.target = target;
        this.cache = new ConcurrentHashMap<>();
        this.cacheDirectory = cacheDirectory;
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(Object target, Class<?> interfaceClass, String cacheDirectory) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[]{interfaceClass},
            new CacheProxy(target, cacheDirectory)
        );
    }

    public static <T> T create(Object target, Class<?> interfaceClass) {
        return create(target, interfaceClass, System.getProperty("java.io.tmpdir"));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);

        if (cacheAnnotation != null) {
            int arg = (int) args[0];
            Map<Integer, Long> methodCache = cache.computeIfAbsent(method, k -> new ConcurrentHashMap<>());

            if (methodCache.containsKey(arg)) {
                return methodCache.get(arg);
            } else {
                long result = (long) method.invoke(target, args);
                methodCache.put(arg, result);

                if (cacheAnnotation.persist()) {
                    persistToDisk(method, methodCache);
                }

                return result;
            }
        }

        return method.invoke(target, args);
    }

    private void persistToDisk(Method method, Map<Integer, Long> methodCache) {
        String fileName = cacheDirectory + File.separator + method.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Map.Entry<Integer, Long> entry : methodCache.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

