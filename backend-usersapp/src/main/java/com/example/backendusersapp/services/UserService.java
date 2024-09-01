package com.example.backendusersapp.services;

import com.example.backendusersapp.models.entities.User;
import com.example.backendusersapp.models.entities.UserRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //listar toddo
    List<User> findAll();
    //buscar or id
    Optional<User> findById(long id);
    //insertar y actualizar
    User save(User user);

    Optional <User> update(UserRequest user, Long id);

    //eliminar
    void remove(Long id);
}
