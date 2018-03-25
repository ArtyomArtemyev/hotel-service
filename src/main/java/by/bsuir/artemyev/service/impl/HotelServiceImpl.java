package by.bsuir.artemyev.service.impl;

import by.bsuir.artemyev.domain.*;
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

import java.util.ArrayList;
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

    @Override
    public List<HotelDto> getHotelsDtos() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<TypeRoom> typeRooms = typeRoomRepository.findAll();
        List<IdFileName> idFileNames = idFileNameRepository.findAll();
        return createHotelsDtos(hotels, typeRooms, idFileNames);
    }

    @Override
    public void deleteHotel(String id) {
        hotelRepository.delete(id);
    }

    private List<HotelDto> createHotelsDtos(List<Hotel> hotels, List<TypeRoom> typeRooms, List<IdFileName> idFileNames) {
        List<HotelDto> hotelDtos = new ArrayList<>();
        for(Hotel hotel: hotels) {
            HotelDto hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setName(hotel.getName());
            hotelDto.setCity(hotel.getCity());
            hotelDto.setAddress(hotel.getAddress());
            hotelDto.setCountOfStars(hotel.getCountOfStars());
            hotelDto.setDescription(hotel.getDescription());
            hotelDto.setRooms(createRoomsDtosForHotelDto(hotel, typeRooms));
            hotelDto.setPhotoName(definePhotoNameForHotel(hotel, idFileNames));
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }

    private String definePhotoNameForHotel(Hotel hotel, List<IdFileName> idFileNames) {
        for(IdFileName idFileName: idFileNames) {
            if(idFileName.getId().equals(hotel.getPhotosIds().get(0))) {
                return idFileName.getFileName();
            }
        }
        return null;
    }

    private List<TypeRoomDto> createRoomsDtosForHotelDto(Hotel hotel, List<TypeRoom> typeRooms) {
        List<TypeRoomDto> hotelTypeRooms = new ArrayList<>();
        for(TypeRoom typeRoom: typeRooms) {
            if(typeRoom.getHotelId().equals(hotel.getId())) {
                TypeRoomDto typeRoomDto = new TypeRoomDto(typeRoom.getId(), typeRoom.getHotelId(), typeRoom.getCountOfMainBed(), typeRoom.getTypeOfMainBed(), typeRoom.getCountOfChildBed(), typeRoom.getPriceForOneChildBed(), typeRoom.getPriceForDay());
                hotelTypeRooms.add(typeRoomDto);
            }
        }
        return hotelTypeRooms;
    }

    private Hotel createHotel(String hotelId, JSONObject jsonObjectByHotelInfo) {
        List<IdFileName> idFilesNames = idFileNameRepository.findAllByFileName(jsonObjectByHotelInfo.getString(PHOTO_NAME));
        Hotel hotel = new Hotel(hotelId, jsonObjectByHotelInfo.getString(HOTEL_NAME), jsonObjectByHotelInfo.getString(HOTEL_CITY),
                jsonObjectByHotelInfo.getString(HOTEL_ADDRESS), jsonObjectByHotelInfo.getInt(COUNT_OF_STARS),
                jsonObjectByHotelInfo.getString(DESCRIPTION), Collections.singletonList(idFilesNames.get(0).getId()));
        logger.info("Successfully created hotel: " + hotel.toString());
        return hotel;
    }

    private void createTypeRoomsForHotel(String hotelId, JSONArray jsonArray) {
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject typeRoomJSONObject = jsonArray.getJSONObject(i);
            TypeRoom typeRoom = new TypeRoom(valueOf(randomUUID()), hotelId,
                    typeRoomJSONObject.getInt(COUNT_OF_MAIN_BED),
                    typeRoomJSONObject.getInt(TYPE_OF_MAIN_BED),
                    typeRoomJSONObject.getInt(COUNT_OF_CHILD_BED),
                    Float.valueOf(typeRoomJSONObject.getInt(PRICE_FOR_CHILD_BED)),
                    Float.valueOf(typeRoomJSONObject.getInt(PRICE)));
            typeRoomRepository.save(typeRoom);
        }
        logger.info("Successfully added type rooms for hotel with id: " + hotelId);
    }
}
