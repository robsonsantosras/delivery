package boasentregas.delivery.models;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document(collection = "calculates")
public class Calculates {

    private static double km = 0.45;
    private static double size = 0.09;


    @Id @Getter @Setter
    private String id;

    @Getter @Setter
    private Customer customer;

    @Getter @Setter
    private Calculate calculate;

    @Getter @Setter
    private List<Ways> waysList;

    public Calculate Date()
    {
        double value;
        int distance=0,duration=0;
        for (int i=0;i<waysList.size();i++)
        {
            distance += waysList.get(i).getDistance().getDistance();
            duration += Math.ceil((waysList.get(i).getDistance().getDuration()/24)+0.5d);
        }
        LocalDate today = LocalDate.now();
        LocalDate date = today.plusDays(duration);
        value = distance * km * size;
        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        value = bd.doubleValue();
        this.calculate = new Calculate(value,date,duration);
        return calculate;

    }

}
