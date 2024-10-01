package com.example.backendusersapp.services;

import com.example.backendusersapp.models.dto.UserDto;
import com.example.backendusersapp.models.entities.User;
import com.example.backendusersapp.models.request.UserRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //listar toddo
    List<UserDto> findAll();
    //buscar or id
    Optional<UserDto> findById(long id);
    //insertar y actualizar
    UserDto save(User user);
    Optional <UserDto> update(UserRequest user, Long id);

    //eliminar
    void remove(Long id);
}
