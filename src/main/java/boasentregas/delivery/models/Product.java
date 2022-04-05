package boasentregas.delivery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

    private static int factor = 6000;

    private double height;
    private double width;
    private double length;

    public double size()
    {
        return (this.height * this.length) * this.width / factor;
    }
}
