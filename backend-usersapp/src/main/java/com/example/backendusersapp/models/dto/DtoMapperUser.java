package com.example.backendusersapp.models.dto;

import com.example.backendusersapp.models.entities.User;

public class DtoMapperUser {

    //public static DtoMapperUser mapper;
    private User user;

    public DtoMapperUser() {
    }

    public static DtoMapperUser builder() {
        return new DtoMapperUser();
    }

    public DtoMapperUser setUser(User user) {
        this.user = user;
        return this;
    }

    public UserDto build(){
        if (user == null){
            throw new RuntimeException("Debe pasar el user entity!");
        }
        boolean isAdmin = user.getRoles().stream().anyMatch(r -> "ROLE_ADMIN".equals(r.getName()));
        return new UserDto(this.user.getId(), user.getUsername(), user.getEmail(), isAdmin);
    }
}
