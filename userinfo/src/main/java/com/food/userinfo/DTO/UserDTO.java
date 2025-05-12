package com.food.userinfo.DTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class UserDTO {

        private int UserId;
        private String UserName;
        private String UserPassword;
        private String address;
        private String city;

        public int getUserId() {
                return UserId;
        }

        public void setUserId(int userId) {
                this.UserId = userId;
        }

        public String getUserName() {
                return UserName;
        }

        public void setUserName(String userName) {
                this.UserName = userName;
        }

        public String getUserPassword() {
                return UserPassword;
        }

        public void setUserPassword(String userPassword) {
                this.UserPassword = userPassword;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }




}
