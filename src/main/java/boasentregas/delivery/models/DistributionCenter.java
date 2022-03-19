package boasentregas.delivery.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistributionCenter {

    private String name;
    private Boolean main;
    private String nameMain;
    private Integer distanceMain;
    private Integer time;
    private Address address;

}
