package boasentregas.delivery.services;

import boasentregas.delivery.models.Distance;
import boasentregas.delivery.models.Addresses;

public interface DistanceService {

    Distance Distance(Addresses addresses);
}
