package com.food.Order.Controller;

import com.food.Order.DTO.OrderDTOFromFE;
import com.food.Order.DTO.UserOrderDTO;
import com.food.Order.Entity.UserOrder;
import com.food.Order.Service.UserOrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetails")
@CrossOrigin
public class UserOrderController {
    @Autowired
    UserOrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<UserOrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE)
    {
        UserOrderDTO savedOrderInDB = orderService.saveUserOrder(orderDTOFromFE);
        return new ResponseEntity<>(savedOrderInDB, HttpStatus.CREATED);
    }
}
