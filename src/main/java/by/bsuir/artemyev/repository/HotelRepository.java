package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}
