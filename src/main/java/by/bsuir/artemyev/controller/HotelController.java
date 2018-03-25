package by.bsuir.artemyev.controller;

import by.bsuir.artemyev.domain.HotelDto;
import by.bsuir.artemyev.service.HotelService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {
    private static Logger logger = LogManager.getLogger(HotelController.class);

    @Autowired
    HotelService hotelService;

    @RequestMapping(method = RequestMethod.POST)
    public void addHotel(@RequestBody String hotelInfo) {
        logger.info("Request to add hotel with hotel info: " + hotelInfo);
        hotelService.addHotel(hotelInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<HotelDto> getHotelsDtos() {
        logger.info("Request to get hotels");
        List<HotelDto> hotelsDtos = hotelService.getHotelsDtos();
        return hotelsDtos == null ? Collections.emptyList() : hotelsDtos;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteHotel(@PathVariable("id") String id) {
        logger.info("Request to delete hotel with id: " +  id);
        hotelService.deleteHotel(id);
    }

}
