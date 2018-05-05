package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class OrderRepositoryExtenedImpl implements OrderRepositoryExtended {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Order findOrder(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").regex("^" + id)), Order.class);
    }
}
