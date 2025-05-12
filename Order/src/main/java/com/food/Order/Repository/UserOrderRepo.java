package com.food.Order.Repository;

import com.food.Order.Entity.UserOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepo extends MongoRepository<UserOrder,Integer> {
}
