package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private HackerNews() {

    }

    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_TEMPLATE = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public static long[] hackerNewsTopStories() {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
            .uri(URI.create(TOP_STORIES_URL))
            .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            String[] ids = body.replaceAll("[\\[\\]]", "").split(",");
            return convertToLongArray(ids);
        } catch (Exception e) {
            return new long[0];
        }
    }

    private static long[] convertToLongArray(String[] ids) {
        long[] result = new long[ids.length];
        for (int i = 0; i < ids.length; i++) {
            result[i] = Long.parseLong(ids[i].trim());
        }
        return result;
    }

    public static String news(long id) throws IOException, InterruptedException {
        String url = String.format(ITEM_URL_TEMPLATE, id);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        return extractNewsTitle(body);
    }

    private static String extractNewsTitle(String json) {
        Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}

