package boasentregas.delivery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Calculate
{
    private Double value;
    private LocalDate estimatedDate;
    private int days;

}
