package by.bsuir.artemyev.service;

import by.bsuir.artemyev.domain.*;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface HotelService {
    Hotel addHotel(String hotelInfo);

    List<HotelDto> getHotelsDtos();

    Hotel deleteHotel(String id);

    Hotel updateHotel(String hotelInfo, String id);

    List<HotelSuggestion> defineOrderSuggestion(String userRequirementInfo) throws ParseException;

    List<Hotel> findHotelByName(String userRequirementInfo);

    List<Hotel> findHotelByCity(String userRequirementInfo);

    Review addReview(String reviewInfo);

    List<ReviewDto> getReviews();

    Review deleteReview(String id);
}
