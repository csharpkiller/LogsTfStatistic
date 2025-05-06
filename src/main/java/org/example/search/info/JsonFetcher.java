package org.example.search.info;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Класс для получения данных по API запросу
 */
public class JsonFetcher {

    /**
     * Возвращает Json по запросу
     * TODO сделать обертку над String? JsonObject с полем Str
     * @param apiUrl
     * @return
     */
    public String getJsonFromUrl(String apiUrl) {
        int maxRedirects = 5;
        int redirectCount = 0;

        while (redirectCount < maxRedirects) {
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader.close();
                    connection.disconnect();
                    return response.toString();

                } else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP ||
                        responseCode == HttpURLConnection.HTTP_MOVED_PERM ||
                        responseCode == HttpURLConnection.HTTP_SEE_OTHER) {

                    String newUrl = connection.getHeaderField("Location");
                    System.out.println("Перенаправление на: " + newUrl);
                    apiUrl = newUrl;
                    redirectCount++;
                    connection.disconnect();

                } else {
                    System.err.println("Ошибка ответа от сервера: " + responseCode);
                    connection.disconnect();
                    return null;
                }

            } catch (IOException e) {
                System.err.println("Ошибка при получении JSON: " + e.getMessage());
                return null;
            }
        }

        System.err.println("Слишком много перенаправлений.");
        return null;
    }
}
