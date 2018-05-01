package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.Hotel;
import by.bsuir.artemyev.domain.InternalUserDto;
import by.bsuir.artemyev.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findAllByHotel(Hotel hotel);
    List<Review> findAllByUserDto(InternalUserDto userDto);
}
