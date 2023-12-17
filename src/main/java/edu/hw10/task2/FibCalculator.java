package edu.hw10.task2;

// Интерфейс FibCalculator
interface FibCalculator {
    @Cache(persist = true)
    long fib(int number);
}
