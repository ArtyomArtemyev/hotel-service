package by.bsuir.artemyev.controller;

import by.bsuir.artemyev.service.HotelService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
