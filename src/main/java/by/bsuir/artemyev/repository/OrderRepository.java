package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.InternalUserDto;
import by.bsuir.artemyev.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByInternalUser(InternalUserDto internalUserDto);
}
