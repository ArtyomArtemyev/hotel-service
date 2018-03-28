package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.ServicePrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicePriceRepository extends MongoRepository<ServicePrice, String> {
}
