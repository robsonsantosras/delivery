package boasentregas.delivery.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {

    @JsonProperty("type")
    String type;

    @JsonProperty("number")
    Long number;
}
