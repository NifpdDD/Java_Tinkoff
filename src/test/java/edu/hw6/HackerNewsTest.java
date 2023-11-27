package edu.hw6;

import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HackerNewsTest {

    @Test
    void find_some_of_hacker_news_top_stories_title() throws IOException, InterruptedException {
        var client = new HackerNews();
        long[] topStories = client.hackerNewsTopStories();

        var hackerNew = topStories[0];
        var newTitle = client.news(hackerNew);

        Assertions.assertThat(newTitle).isEqualTo(client.news(hackerNew));
    }
}
