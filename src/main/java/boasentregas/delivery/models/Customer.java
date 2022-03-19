    package boasentregas.delivery.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document (collation = "customers")
@Getter

public class Customer
{

    @JsonProperty("document")
    Document document;

    @JsonProperty("name")
    String name;

    @JsonProperty("address")
    Address address;
}
