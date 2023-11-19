package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class HackerNewsTest {

    @Test
    void hackerNewsTopStories() throws IOException, InterruptedException {
        HackerNews hackerNews = new HackerNews();
        long[] topStories = hackerNews.hackerNewsTopStories();
        System.out.println(Arrays.toString(topStories));
        String newsTitle = hackerNews.news(112397812);
        System.out.println(newsTitle);

    }
}
