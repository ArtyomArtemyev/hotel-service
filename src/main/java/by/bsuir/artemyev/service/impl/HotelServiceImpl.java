package by.bsuir.artemyev.service.impl;

import by.bsuir.artemyev.domain.*;
import by.bsuir.artemyev.repository.HotelRepository;
import by.bsuir.artemyev.repository.IdFileNameRepository;
import by.bsuir.artemyev.repository.ServicePriceRepository;
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

    private static final String TYPE_ROOM_NAME = "typeRoomName";
    private static final String TYPE_ROOM_WORLD_NAME = "typeRoomWorldName";
    private static final String EXIST_LIVING_ROOM = "existLivingRoom";
    private static final String EXIST_SLEEPING_ROOM = "existSleepingRoom";
    private static final String EXIST_CABINET = "existCabinet";
    private static final String EXIST_MEETING_ROOM = "existMeetingRoom";
    private static final String EXIST_SHOWING_ROOM = "existShowingRoom";
    private static final String EXIST_BATH_ROOM = "existBathRoom";
    private static final String EXIST_TV = "existTV";
    private static final String EXIST_BAR = "existBar";
    private static final String EXIST_WI_FI = "existWiFi";
    private static final String EXIST_BALCONY = "existBalcony";
    private static final String EXIST_KITCHEN = "existKitchen";
    private static final String EXIST_DINING_ROOM = "existDiningRoom";
    private static final String EXIST_WC_ROOM = "existWCRoom";
    private static final String EXIST_ADDITIONAL_WC_ROOM = "existAdditionalWCRoom";
    private static final String COUNT_OF_MAN = "countOfMan";
    private static final String TYPE_OF_MAIN_BED1 = "typeOfMainBed";
    private static final String EXIST_CHILD_BED = "existChildBed";
    private static final String TYPE_HOTELS_ROOMS = "rooms";
    private static final String HOTEL_NAME = "name";
    private static final String HOTEL_CITY = "city";
    private static final String HOTEL_ADDRESS = "address";
    private static final String COUNT_OF_STARS = "countOfStars";
    private static final String DESCRIPTION = "description";
    private static final String PHOTO_NAME = "photoName";
    private static final String SERVICES_PRICE = "servicesPrice";
    private static final String SERVICE = "service";
    private static final String PRICE = "price";
    public static final String SERVICES_PRICES = "servicesPrices";

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    IdFileNameRepository idFileNameRepository;

    @Autowired
    ServicePriceRepository servicePriceRepository;

    @Override
    public Hotel addHotel(String hotelInfo) {
        JSONObject jsonObjectByHotelInfo = new JSONObject(hotelInfo);
        List<String> roomsIds = createTypeRoomsForHotel(jsonObjectByHotelInfo.getJSONArray(TYPE_HOTELS_ROOMS));
        List<String> servicesPricesIds = createServicesPricesForHotel(jsonObjectByHotelInfo.getJSONArray(SERVICES_PRICE));
        Hotel hotel = createHotel(jsonObjectByHotelInfo, roomsIds, servicesPricesIds);
        hotelRepository.save(hotel);
        logger.info("Successfully added hotel with id: " + hotel.getId());
        return hotelRepository.findOne(hotel.getId());
    }

    @Override
    public List<HotelDto> getHotelsDtos() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<TypeRoom> typeRooms = typeRoomRepository.findAll();
        List<ServicePrice> servicePrices = servicePriceRepository.findAll();
        List<IdFileName> idFileNames = idFileNameRepository.findAll();
        return createHotelsDtos(hotels, typeRooms, servicePrices, idFileNames);
    }

    @Override
    public Hotel deleteHotel(String hotelId) {
        Hotel hotel = hotelRepository.findOne(hotelId);
        hotelRepository.delete(hotel);
        logger.info("Successfully deleted hotel with id: " + hotelId);
        //TODO: bulk delete rooms. services, photoName
        return hotelRepository.findOne(hotelId);
    }

    @Override
    public Hotel updateHotel(String hotelInfo, String id) {
        Hotel hotelForEdit = hotelRepository.findOne(id);
        JSONObject jsonObjectByHotelInfo = new JSONObject(hotelInfo);
        List<IdFileName> idFileName = idFileNameRepository.findAllByFileName(jsonObjectByHotelInfo.getString(PHOTO_NAME));
        List<String> roomsIds = createTypeRoomsForHotel(jsonObjectByHotelInfo.getJSONArray(TYPE_HOTELS_ROOMS));
        List<String> servicesPricesIds = createServicesPricesForHotel(jsonObjectByHotelInfo.getJSONArray(SERVICES_PRICES));
        Hotel hotel = new Hotel(id,
                jsonObjectByHotelInfo.getString(HOTEL_NAME),
                jsonObjectByHotelInfo.getString(HOTEL_CITY),
                jsonObjectByHotelInfo.getString(HOTEL_ADDRESS),
                jsonObjectByHotelInfo.getInt(COUNT_OF_STARS),
                jsonObjectByHotelInfo.getString(DESCRIPTION),
                Collections.singletonList(idFileName.get(0).getId()),
                roomsIds,
                servicesPricesIds);
        hotelRepository.delete(hotelForEdit);
        hotelRepository.save(hotel);
        logger.info("Successfully update hotel with id: " + id);
        return hotel;
    }

    private List<HotelDto> createHotelsDtos(List<Hotel> hotels, List<TypeRoom> typeRooms, List<ServicePrice> servicePrices, List<IdFileName> idFileNames) {
        List<HotelDto> hotelDtos = new ArrayList<>();
        for (Hotel hotel : hotels) {
            HotelDto hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setName(hotel.getName());
            hotelDto.setCity(hotel.getCity());
            hotelDto.setAddress(hotel.getAddress());
            hotelDto.setCountOfStars(hotel.getCountOfStars());
            hotelDto.setDescription(hotel.getDescription());
            hotelDto.setRooms(createRoomsDtosForHotelDto(hotel, typeRooms));
            hotelDto.setServicesPrices(createPriceServicesForHotelDto(hotel, servicePrices));
            hotelDto.setPhotoName(definePhotoNameForHotel(hotel, idFileNames));
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }

    private String definePhotoNameForHotel(Hotel hotel, List<IdFileName> idFileNames) {
        for (IdFileName idFileName : idFileNames) {
            if (idFileName.getId().equals(hotel.getPhotosIds().get(0))) {
                return idFileName.getFileName();
            }
        }
        return null;
    }

    private List<TypeRoom> createRoomsDtosForHotelDto(Hotel hotel, List<TypeRoom> typeRooms) {
        List<TypeRoom> hotelTypeRooms = new ArrayList<>();
        for (int i = 0; i < hotel.getTypeRoomsIds().size(); i++) {
            for (TypeRoom typeRoomInStore : typeRooms) {
                if (typeRoomInStore.getId().equals(hotel.getTypeRoomsIds().get(i))) {
                    hotelTypeRooms.add(typeRoomInStore);
                }
            }
        }
        return hotelTypeRooms;
    }

    private List<ServicePrice> createPriceServicesForHotelDto(Hotel hotel, List<ServicePrice> servicePrices) {
        List<ServicePrice> servicePriceList = new ArrayList<>();
        for (int i = 0; i < hotel.getServicesPrices().size(); i++) {
            for (int k = 0; k < servicePrices.size(); k++) {
                if (servicePrices.get(k).getId().equals(hotel.getServicesPrices().get(i))) {
                    servicePriceList.add(servicePrices.get(k));
                }
            }
        }
        return servicePriceList;
    }

    private Hotel createHotel(JSONObject jsonObjectByHotelInfo, List<String> roomsIds, List<String> servicesIds) {
        List<IdFileName> idFilesNames = idFileNameRepository.findAllByFileName(jsonObjectByHotelInfo.getString(PHOTO_NAME));
        Hotel hotel = new Hotel(valueOf(randomUUID()),
                jsonObjectByHotelInfo.getString(HOTEL_NAME),
                jsonObjectByHotelInfo.getString(HOTEL_CITY),
                jsonObjectByHotelInfo.getString(HOTEL_ADDRESS),
                jsonObjectByHotelInfo.getInt(COUNT_OF_STARS),
                jsonObjectByHotelInfo.getString(DESCRIPTION),
                Collections.singletonList(idFilesNames.get(0).getId()),
                roomsIds,
                servicesIds);
        logger.info("Successfully created hotel: " + hotel.toString());
        return hotel;
    }

    private List<String> createTypeRoomsForHotel(JSONArray jsonArray) {
        List<String> typeRoomsIds = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject typeRoomJSONObject = jsonArray.getJSONObject(i);
            String typeRoomId = valueOf(randomUUID());
            TypeRoom typeRoom = new TypeRoom(typeRoomId, typeRoomJSONObject.getString(TYPE_ROOM_NAME),
                    typeRoomJSONObject.getString(TYPE_ROOM_WORLD_NAME), typeRoomJSONObject.getBoolean(EXIST_LIVING_ROOM),
                    typeRoomJSONObject.getBoolean(EXIST_SLEEPING_ROOM), typeRoomJSONObject.getBoolean(EXIST_CABINET),
                    typeRoomJSONObject.getBoolean(EXIST_MEETING_ROOM), typeRoomJSONObject.getBoolean(EXIST_SHOWING_ROOM),
                    typeRoomJSONObject.getBoolean(EXIST_BATH_ROOM), typeRoomJSONObject.getBoolean(EXIST_TV), typeRoomJSONObject.getBoolean(EXIST_BAR),
                    typeRoomJSONObject.getBoolean(EXIST_WI_FI), typeRoomJSONObject.getBoolean(EXIST_BALCONY), typeRoomJSONObject.getBoolean(EXIST_KITCHEN),
                    typeRoomJSONObject.getBoolean(EXIST_DINING_ROOM), typeRoomJSONObject.getBoolean(EXIST_WC_ROOM), typeRoomJSONObject.getBoolean(EXIST_ADDITIONAL_WC_ROOM),
                    typeRoomJSONObject.getInt(COUNT_OF_MAN), typeRoomJSONObject.getString(TYPE_OF_MAIN_BED1), typeRoomJSONObject.getBoolean(EXIST_CHILD_BED));
            typeRoomRepository.save(typeRoom);
            typeRoomsIds.add(typeRoomId);
        }
        logger.info("Successfully added type rooms: ");
        return typeRoomsIds;
    }

    private List<String> createServicesPricesForHotel(JSONArray jsonArray) {
        List<String> servicesPricesIds = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject servicePriceJSONObject = jsonArray.getJSONObject(i);
            String servicePriceId = valueOf(randomUUID());
            ServicePrice servicePrice = new ServicePrice(servicePriceId, servicePriceJSONObject.getString(SERVICE), new Double(servicePriceJSONObject.getDouble(PRICE)).floatValue());
            servicePriceRepository.save(servicePrice);
            servicesPricesIds.add(servicePriceId);
        }
        logger.info("Successfully added prices: ");
        return servicesPricesIds;
    }
}
