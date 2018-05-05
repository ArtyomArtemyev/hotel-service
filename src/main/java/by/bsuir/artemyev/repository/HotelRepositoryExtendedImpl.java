package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class HotelRepositoryExtendedImpl implements HotelRepositoryExtended {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void deleteHotel(String id) {
        mongoTemplate.updateMulti(new Query(Criteria.where("id").in(Arrays.asList(id))), new Update().set("entityState", "DELETED"), Hotel.class);
    }
}
