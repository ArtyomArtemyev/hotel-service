package by.bsuir.artemyev.service;

import by.bsuir.artemyev.domain.HotelDto;

import java.util.List;

public interface HotelService {
    void addHotel(String hotelInfo);
    List<HotelDto> getHotelsDtos();
    void deleteHotel(String id);
}
