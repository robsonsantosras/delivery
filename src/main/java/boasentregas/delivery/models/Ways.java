package boasentregas.delivery.models;

import boasentregas.delivery.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ways {
    private int position;

    private Status status;

    private Addresses addresses;

    private Distance distance;


}

