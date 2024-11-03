package com.example.backendusersapp.services;

import com.example.backendusersapp.models.IUser;
import com.example.backendusersapp.models.dto.DtoMapperUser;
import com.example.backendusersapp.models.dto.UserDto;
import com.example.backendusersapp.models.entities.Role;
import com.example.backendusersapp.models.entities.User;
import com.example.backendusersapp.models.request.UserRequest;
import com.example.backendusersapp.repositories.RoleRepository;
import com.example.backendusersapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> users = (List<User>) repository.findAll();
        return users
                .stream().map(u -> DtoMapperUser.builder().setUser(u).build())
                .collect(Collectors.toList());
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Optional<UserDto> findById(long id) {
//        Optional<User> o = repository.findById(id);
//        if (o.isPresent()) {
//            return Optional.of(DtoMapperUser.builder().setUser(o.orElseThrow()).build()
//            );
//        }
//        return Optional.empty();
//    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> findById(long id) {
        return repository.findById(id).map(u->
                DtoMapperUser.builder().setUser(u).build());
    }

    @Override
    @Transactional
    public UserDto save(User user) {
//        String passwordBCrypt = passwordEncoder.encode(user.getPassword());
//        user.setPassword(passwordBCrypt);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        List<Role> roles = getRoles(user);

        user.setRoles(roles);
        return DtoMapperUser.builder().setUser(repository.save(user)).build();
    }

    @Override
    @Transactional
    public Optional<UserDto> update(UserRequest user, Long id) {
        Optional<User> o = repository.findById(id);
        User userOptional = null;
        if (o.isPresent()) {

            List<Role> roles = getRoles(user);

            User userDb = o.orElseThrow();
            userDb.setRoles(roles);
            userDb.setUsername(user.getUsername());
            userDb.setEmail(user.getEmail());
            //return Optional.of(this.save(userDb));
            userOptional = repository.save(userDb);
        }
        return Optional.ofNullable(DtoMapperUser.builder().setUser(userOptional).build());
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }

    private List<Role> getRoles(IUser user){
        Optional<Role> ou = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        if (ou.isPresent()) {
            roles.add(ou.orElseThrow());
        }
        if(user.isAdmin()){
            Optional<Role> oa = roleRepository.findByName("ROLE_ADMIN");
            if(oa.isPresent()){
                roles.add(oa.get());
            }
        }
        return roles;
    }
}
