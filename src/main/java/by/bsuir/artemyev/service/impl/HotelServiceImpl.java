package by.bsuir.artemyev.service.impl;

import by.bsuir.artemyev.domain.Hotel;
import by.bsuir.artemyev.domain.IdFileName;
import by.bsuir.artemyev.domain.TypeRoom;
import by.bsuir.artemyev.repository.HotelRepository;
import by.bsuir.artemyev.repository.IdFileNameRepository;
import by.bsuir.artemyev.repository.TypeRoomRepository;
import by.bsuir.artemyev.service.HotelService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.UUID.randomUUID;

@Service
public class HotelServiceImpl implements HotelService {
    private static Logger logger = LogManager.getLogger(HotelServiceImpl.class);

    private static final String TYPE_HOTELS_ROOMS = "rooms";
    private static final String COUNT_OF_MAIN_BED = "countOfBed";
    private static final String TYPE_OF_MAIN_BED = "typeOfBed";
    private static final String COUNT_OF_CHILD_BED = "countOfChildBed";
    private static final String PRICE_FOR_CHILD_BED = "priceForChildBed";
    private static final String PRICE = "price";
    private static final String HOTEL_NAME = "name";
    private static final String HOTEL_CITY = "city";
    private static final String HOTEL_ADDRESS = "address";
    private static final String COUNT_OF_STARS = "countOfStars";
    private static final String DESCRIPTION = "description";
    private static final String PHOTO_NAME = "photoName";

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    IdFileNameRepository idFileNameRepository;

    @Override
    public void addHotel(String hotelInfo) {
        String hotelId = valueOf(randomUUID());
        JSONObject jsonObjectByHotelInfo = new JSONObject(hotelInfo);
        createTypeRoomsForHotel(hotelId, jsonObjectByHotelInfo.getJSONArray(TYPE_HOTELS_ROOMS));
        Hotel hotel = createHotel(hotelId, jsonObjectByHotelInfo);
        hotelRepository.save(hotel);
        logger.info("Successfully added hotel with id: " + hotelId);
    }

    private Hotel createHotel(String hotelId, JSONObject jsonObjectByHotelInfo) {
        List<IdFileName> idFilesNames = idFileNameRepository.findAllByFileName(jsonObjectByHotelInfo.getString(PHOTO_NAME));
        Hotel hotel = new Hotel(hotelId, jsonObjectByHotelInfo.getString(HOTEL_NAME), jsonObjectByHotelInfo.getString(HOTEL_CITY),
                jsonObjectByHotelInfo.getString(HOTEL_ADDRESS), Integer.valueOf(jsonObjectByHotelInfo.getString(COUNT_OF_STARS)),
                jsonObjectByHotelInfo.getString(DESCRIPTION), Collections.singletonList(idFilesNames.get(0).getId()));
        logger.info("Successfully created hotel: " + hotel.toString());
        return hotel;
    }

    private void createTypeRoomsForHotel(String hotelId, JSONArray jsonArray) {
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject typeRoomJSONObject = jsonArray.getJSONObject(i);
            TypeRoom typeRoom = new TypeRoom(valueOf(randomUUID()), hotelId,
                    Integer.valueOf(typeRoomJSONObject.getString(COUNT_OF_MAIN_BED)),
                    Integer.valueOf(typeRoomJSONObject.getString(TYPE_OF_MAIN_BED)),
                    Integer.valueOf(typeRoomJSONObject.getString(COUNT_OF_CHILD_BED)),
                    Float.valueOf(typeRoomJSONObject.getString(PRICE_FOR_CHILD_BED)),
                    Float.valueOf(typeRoomJSONObject.getString(PRICE)));
            typeRoomRepository.save(typeRoom);
        }
        logger.info("Successfully added type rooms for hotel with id: " + hotelId);
    }
}
