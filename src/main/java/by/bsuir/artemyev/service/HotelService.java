package by.bsuir.artemyev.service;

import by.bsuir.artemyev.domain.Hotel;
import by.bsuir.artemyev.domain.HotelDto;

import java.util.List;

public interface HotelService {
    Hotel addHotel(String hotelInfo);
    List<HotelDto> getHotelsDtos();
    Hotel deleteHotel(String id);
    Hotel updateHotel(String hotelInfo, String id);
}
