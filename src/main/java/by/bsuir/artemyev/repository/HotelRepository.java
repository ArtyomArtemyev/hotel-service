package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {
    List<Hotel> findAllByCityAndEntityState(String city, String entityState);
    List<Hotel> findAllByNameAndEntityState(String name, String entityState);
}
