package boasentregas.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = { "boasentregas.delivery", "boasentregas.security"})
@EnableMongoRepositories({"boasentregas.delivery.repositories","boasentregas.security.repositories"})
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
