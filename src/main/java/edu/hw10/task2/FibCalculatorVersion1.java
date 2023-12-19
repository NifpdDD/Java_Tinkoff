package edu.hw10.task2;

public class FibCalculatorVersion1 implements  FibCalculator {

    @Override
    public long fib(int number) {
            long[] fibArray = new long[number + 1];
            fibArray[0] = 0;
            fibArray[1] = 1;
            for (int i = 2; i <= number; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            }
            return fibArray[number];
    }
}
