package by.bsuir.artemyev.controller;

import by.bsuir.artemyev.domain.Review;
import by.bsuir.artemyev.domain.ReviewDto;
import by.bsuir.artemyev.service.HotelService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private static Logger logger = LogManager.getLogger(ReviewController.class);

    @Autowired
    HotelService hotelService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Review> addReview(@RequestBody String reviewInfo) {
        logger.info("Request to add review for hotel: " + reviewInfo);
        return new ResponseEntity<>(hotelService.addReview(reviewInfo), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ReviewDto> getReviews() {
        logger.info("Request to get all reviews");
        List<ReviewDto> reviews = hotelService.getReviews();
        return reviews == null ? Collections.emptyList() : reviews;
    }
}
