package boasentregas.delivery.services;

import boasentregas.delivery.models.Calculates;
import boasentregas.delivery.models.Destination;


public interface CalculateService {

    Calculates FindByID(String id);
    Calculates Calculate(Destination destination);
}
