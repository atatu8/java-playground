package atatu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class BankReserve {

    public static void read() {
        try {
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false);

            String content = HttpClient.get("https://bank.gov.ua/NBUStatService/v1/statdirectory/res?date=202301&json");

            ReserveRecord[] reserveRecords = objectMapper.readValue(content, ReserveRecord[].class);
            for (ReserveRecord reserveRecord : reserveRecords) {
                System.out.printf("%s, %s, \"%s\", %f\n", reserveRecord.date(), reserveRecord.apiId(),
                        reserveRecord.name(), reserveRecord.value());
            }

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
