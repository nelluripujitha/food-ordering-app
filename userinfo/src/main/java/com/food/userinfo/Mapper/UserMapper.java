package com.food.userinfo.Mapper;

import com.food.userinfo.DTO.UserDTO;

import com.food.userinfo.Entity.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfo mapUserDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserInfo user = new UserInfo();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setUserPassword(userDTO.getUserPassword());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());


        return user;
    }


    public UserDTO mapUserToUserDTO(UserInfo user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());

        return userDTO;
    }

}
