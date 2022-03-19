package boasentregas.delivery.repositories;

import boasentregas.delivery.models.Calculates;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalculateRepository extends MongoRepository<Calculates,String> {

}
