package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.DefaultTypeRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DefaultTypeRoomRepository extends MongoRepository<DefaultTypeRoom, String> {
}
