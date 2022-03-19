package boasentregas.delivery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ways {
    private int position;

    private Addresses addresses;

    private Distance distance;
}
