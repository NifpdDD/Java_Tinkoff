package edu.hw10.task2;

public class Main {
    public static void main(String[] args) {
        FibCalculator fibCalculator = new FibCalculator() {
            @Override
            public long fib(int number) {
                if (number <= 1) {
                    return number;
                } else {
                    return fib(number - 1) + fib(number - 2);
                }
            }
        };

        FibCalculator fibProxy = CacheProxy.create(fibCalculator, FibCalculator.class);

        System.out.println(fibProxy.fib(10));
        System.out.println(fibProxy.fib(10));

        FibCalculator fibProxyWithPersist = CacheProxy.create(fibCalculator, FibCalculator.class, "src/main/resources");

        System.out.println(fibProxyWithPersist.fib(10));
    }

}

