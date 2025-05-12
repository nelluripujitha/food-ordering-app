package com.food.userinfo.Controller;

import com.food.userinfo.DTO.UserDTO;
import com.food.userinfo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
     UserDTO userdto= userService.addUser(userDTO);
     return new ResponseEntity<>(userdto, HttpStatus.CREATED);
    }
    @GetMapping("/getUser/{UserId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer UserId)
    {
        return userService.getUserById(UserId);
    }

}
