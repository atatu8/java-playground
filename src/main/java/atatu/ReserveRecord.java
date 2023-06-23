package atatu;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReserveRecord(@JsonProperty("dt") String date, @JsonProperty("id_api") String apiId,
        @JsonProperty("txten") String name, float value) {

}
