package edu.hw3.task6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.List;
import java.util.PriorityQueue;

public class StockPull implements StockMarket {
    final List<Stock> stockList;

    StockPull() {
        this.stockList = new ArrayList<>();
    }

    @Override public void add(Stock stock) {
        stockList.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        if (stockList.isEmpty()) {
            throw new EmptyStackException();
        }
        stockList.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        PriorityQueue<Stock> priorityQueue =
            new PriorityQueue<>(Comparator.comparingDouble(Stock::getPrice).reversed());
        priorityQueue.addAll(stockList);
        return priorityQueue.peek();
    }
}
