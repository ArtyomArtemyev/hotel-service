package by.bsuir.artemyev.controller;

        import by.bsuir.artemyev.domain.Review;
        import by.bsuir.artemyev.domain.ReviewDto;
        import by.bsuir.artemyev.service.HotelService;
        import org.apache.log4j.LogManager;
        import org.apache.log4j.Logger;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private static Logger logger = LogManager.getLogger(ReviewController.class);

    private static final String SUCCESSFUL_RESPONSE = "successful";
    private static final String UN_SUCCESSFUL_RESPONSE = "unsuccessful";

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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteReview(@PathVariable("id") String id) {
        logger.info("Request to delete review");
        return hotelService.deleteReview(id) == null ? new ResponseEntity<>(SUCCESSFUL_RESPONSE, HttpStatus.OK) : new ResponseEntity<>(UN_SUCCESSFUL_RESPONSE, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/by-user", method = RequestMethod.POST)
    public List<Review> getUserReview(@RequestBody String tokenInfo) {
        logger.info("Request to get reviews by user with token: " + tokenInfo);
        List<Review> reviewDtos = hotelService.getUserReviews(tokenInfo);
        return reviewDtos == null ? Collections.emptyList() : reviewDtos;
    }

}
