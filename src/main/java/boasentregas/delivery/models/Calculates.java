package boasentregas.delivery.models;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "calculates")
public class Calculates {
    @Id
    private String id;

    private Customer customer;

    private Calculate calculate;
    private List<Ways> waysList;

}
