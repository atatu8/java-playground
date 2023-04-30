package atatu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public static String get(String url) {
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return sb.toString();
    }
}