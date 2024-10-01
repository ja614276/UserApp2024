package com.example.backendusersapp.models.dto;

import com.example.backendusersapp.models.entities.User;

public class DtoMapperUser {

    public static DtoMapperUser mapper;
    private User user;

    public DtoMapperUser() {
    }

    public static DtoMapperUser builder() {
        mapper = new DtoMapperUser();
        return mapper;
    }

    public DtoMapperUser setUser(User user) {
        this.user = user;
        return mapper;
    }

    public UserDto build(){
        if (user == null){
            throw new RuntimeException("Debe pasar el user entity!");
        }
        return new UserDto(this.user.getId(), user.getUsername(), user.getEmail());
    }
}
