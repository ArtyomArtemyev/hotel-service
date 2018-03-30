package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.TypeRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRoomRepository extends MongoRepository<TypeRoom, String> {
    TypeRoom findByIdAndIsExistChildBed(String id, Boolean existChildBed);
}
