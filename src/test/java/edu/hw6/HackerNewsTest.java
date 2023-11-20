package edu.hw6;

import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HackerNewsTest {

    @Test
    void find_some_of_hacker_news_top_stories_title() throws IOException, InterruptedException {
        long[] topStories = HackerNews.hackerNewsTopStories();

        var hackerNew = topStories[0];
        var newTitle = HackerNews.news(hackerNew);

        Assertions.assertThat(newTitle).isEqualTo("Emmett Shear becomes interim OpenAI CEO as Altman talks break down");
    }
}
