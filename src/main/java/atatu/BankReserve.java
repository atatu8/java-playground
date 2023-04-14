package atatu;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class BankReserve {
    public static void read() {

        String query = "https://bank.gov.ua/NBUStatService/v1/statdirectory/res?date=202301&json";
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                    }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(sb.toString());
            Iterator<JsonNode> itr = jsonNode.iterator();

            for (int i = 0; i < jsonNode.size(); i++) {
                JsonNode innerNode = itr.next();
                System.out.println((innerNode.get("dt")).textValue() + " " + innerNode.get("id_api").textValue()
                        + " " + innerNode.get("txten") + " " + innerNode.get("value"));
            }

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}