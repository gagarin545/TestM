package ru.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetResultPage {
    private String url_page;

    public GetResultPage(String url_page) {
        this.url_page = url_page;
    }

    public BufferedReader getResultTest() throws IOException {
        URL url = new URL(url_page);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection != null) {
            connection.setReadTimeout(60 * 1000); // ожидание на 5 сек
            connection.setDoOutput(true); // соединение доступно для вывода
            connection.setUseCaches(false); // не использовать кэш
            connection.setRequestMethod("GET"); // метод post
            connection.setRequestProperty("connection", "keep-alive");
            connection.setRequestProperty("Charset", "UTF-8");
        }
        connection.connect();
        return new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
    }
}
