package boasentregas.delivery.services;

import boasentregas.delivery.models.DistributionCenter;

public interface FindDistributionCenter {
    DistributionCenter find(int zipcode);

    DistributionCenter findName(String name);
}
