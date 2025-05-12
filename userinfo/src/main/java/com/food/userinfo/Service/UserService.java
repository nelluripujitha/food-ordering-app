package com.food.userinfo.Service;

import com.food.userinfo.DTO.UserDTO;

import com.food.userinfo.Entity.UserInfo;
import com.food.userinfo.Mapper.UserMapper;
import com.food.userinfo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userrepo;
    @Autowired
    UserMapper usermapper;

    public UserDTO addUser(UserDTO userDTO)
    {

        UserInfo user = userrepo.save(usermapper.mapUserDTOToUser(userDTO));

        return usermapper.mapUserToUserDTO(user);
    }

    public ResponseEntity<UserDTO> getUserById(Integer userId)
    {
       Optional<UserInfo> user= userrepo.findById(userId);
       if(user.isPresent())
       {    UserDTO fetcheduser = usermapper.mapUserToUserDTO(user.get());
           return new ResponseEntity<>(fetcheduser, HttpStatus.OK);
       }
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}