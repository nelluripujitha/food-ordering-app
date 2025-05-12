package com.food.Order.Service;

import com.food.Order.DTO.OrderDTOFromFE;
import com.food.Order.DTO.UserDTO;
import com.food.Order.DTO.UserOrderDTO;
import com.food.Order.Entity.UserOrder;
import com.food.Order.Mapper.UserOrderMapping;
import com.food.Order.Repository.UserOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserOrderService {
    @Autowired
    UserOrderRepo userOrderRepo;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserOrderMapping userOrderMapping;

    public UserOrderDTO saveUserOrder(OrderDTOFromFE orderDTOFromFE)
    {
        Integer newOrderId=sequenceGenerator.generateNextOrderId();
        UserDTO userDTO  = getUserDetailsFromUserId(orderDTOFromFE.getUserId());
        UserOrder orderToBeSaved= new UserOrder(newOrderId,orderDTOFromFE.getFoodItems(),orderDTOFromFE.getRestaurant(),userDTO);
        userOrderRepo.save(orderToBeSaved);
        return userOrderMapping.mapuserOrderToUserOrderDTO(orderToBeSaved);

    }

    private UserDTO getUserDetailsFromUserId(Integer userId)
    {
      return restTemplate.getForObject("http://USER-SERVICE/user/getUser/" +userId, UserDTO.class);
    }
}
