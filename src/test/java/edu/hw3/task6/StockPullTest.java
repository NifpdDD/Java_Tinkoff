package edu.hw3.task6;

import java.util.EmptyStackException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class StockPullTest {

    @ParameterizedTest
    @MethodSource("stockProvider")
   void if_add_stock_shoud_contains_in_stock_pull(Stock stock) {
        var stockPull = new StockPull();

        stockPull.add(stock);

        Assertions.assertThat(stockPull.stockList).contains(stock);
    }

    private static Stream<Stock> stockProvider() {
        return Stream.of(
            new Stock("Pivo", 15),
            new Stock("Vodka", 25),
            new Stock("Z", 25)
        );
    }

    @ParameterizedTest
    @MethodSource("stockProvider")
     void if_remove_stock_shoudnot_contains_in_stock_pull(Stock stock) {
        var stockPull = new StockPull();

        stockPull.add(stock);
        stockPull.remove(stock);

        Assertions.assertThat(stockPull.stockList).doesNotContain(stock);
    }

    @Test
    void name() {
        var stockPull = new StockPull();
        var stock = new Stock("Pivo", 15);

        Assertions.assertThatThrownBy(()->stockPull.remove(stock)).isInstanceOf(EmptyStackException.class);
    }

    @Test
    void mostValuableStock() {
        var stockPull = new StockPull();
        var stock = new Stock("Pivo", 15);
        var stock1 = new Stock("Vodka", 20);
        var stock2 = new Stock("Z", 25);

        stockPull.add(stock);
        stockPull.add(stock1);
        stockPull.add(stock2);
        var mvs = stockPull.mostValuableStock();

        Assertions.assertThat(mvs).isEqualTo(stock2);

    }
}
