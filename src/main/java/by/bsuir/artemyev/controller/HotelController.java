package by.bsuir.artemyev.controller;

import by.bsuir.artemyev.domain.*;
import by.bsuir.artemyev.repository.DefaultTypeRoomRepository;
import by.bsuir.artemyev.repository.TypeRoomRepository;
import by.bsuir.artemyev.service.HotelService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {
    private static Logger logger = LogManager.getLogger(HotelController.class);

    private static final String SUCCESSFUL_RESPONSE = "successful";
    private static final String UN_SUCCESSFUL_RESPONSE = "unsuccessful";

    @Autowired
    HotelService hotelService;

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @Autowired
    DefaultTypeRoomRepository defaultTypeRoomRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addHotel(@RequestBody String hotelInfo) {
        logger.info("Request to add hotel with hotel info: " + hotelInfo);
        if (hotelService.addHotel(hotelInfo) != null) return new ResponseEntity<>(SUCCESSFUL_RESPONSE, HttpStatus.OK);
        else return new ResponseEntity<>(UN_SUCCESSFUL_RESPONSE, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<HotelDto> getHotelsDtos() {
        logger.info("Request to get hotels");
        List<HotelDto> hotelsDtos = hotelService.getHotelsDtos();
        return hotelsDtos == null ? Collections.emptyList() : hotelsDtos;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteHotel(@PathVariable("id") String id) {
        logger.info("Request to delete hotel with id: " + id);
        return hotelService.deleteHotel(id) == null ? new ResponseEntity<>(SUCCESSFUL_RESPONSE, HttpStatus.OK) : new ResponseEntity<>(UN_SUCCESSFUL_RESPONSE, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/type-rooms", method = RequestMethod.GET)
    public List<DefaultTypeRoom> deleteHotel() {
        logger.info("Request to get default type rooms");
        List<DefaultTypeRoom> defaultTypeRooms = defaultTypeRoomRepository.findAll();
        return defaultTypeRooms == null ? Collections.emptyList() : defaultTypeRooms;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public List<String> updateHotel(@RequestBody String hotelInfo, @PathVariable("id") String id) {
        logger.info("Request to update hotel: " + hotelInfo);
        Hotel hotel = hotelService.updateHotel(hotelInfo, id);
        return hotel == null ? Collections.emptyList() : Collections.singletonList(hotel.getId());
    }

    @RequestMapping(value = "/find-hotel", method = RequestMethod.POST)
    public List<?> findHotel(@RequestBody String userRequirementInfo) throws ParseException {
        logger.info("Request to find hotel, room by this requirement" + userRequirementInfo);
        List<HotelSuggestion> orderSuggestions = hotelService.defineOrderSuggestion(userRequirementInfo);
        return orderSuggestions == null ? Collections.emptyList() : orderSuggestions;

    }

}
