package atatu;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonProcessingException;

class HttpClient {
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

public class BankReserve {
    /*public String dt;
    public String txt;
    public String txten;
    public String id_api;
    public int leveli;
    public String parent;
    public String freq;
    public float value;
    public String tzep;*/

    public static void read() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String content = HttpClient.get("https://bank.gov.ua/NBUStatService/v1/statdirectory/res?date=202301&json");
            JsonNode jsonNode = objectMapper.readTree(content);
            Iterator<JsonNode> itr = jsonNode.iterator();

            for (int i = 0; i < jsonNode.size(); i++) {
                JsonNode innerNode = itr.next();
                System.out.println((innerNode.get("dt")).textValue() + " " + innerNode.get("id_api").textValue()
                        + " " + innerNode.get("txten") + " " + innerNode.get("value"));
            }

            // BankReserve[] bankReserves = objectMapper.readValue(content, BankReserve[].class);
            // for (BankReserve bankReserve : bankReserves) {
            //     System.out.printf("%s, %s \"%s\", %f\n", bankReserve.dt, bankReserve.id_api, bankReserve.txten, bankReserve.value);
            // }

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}