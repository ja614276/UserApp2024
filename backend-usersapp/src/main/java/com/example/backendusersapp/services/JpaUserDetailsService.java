package com.example.backendusersapp.services;

import com.example.backendusersapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
//public class JpaUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Override
//    @Transactional(readOnly = true) //import spring
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<com.example.backendusersapp.models.entities.User> o = repository.getUserByUsername(username);
////        if(!username.equals("admin")){
//        if(!o.isPresent()){
//            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema.", username));
//        }
//        com.example.backendusersapp.models.entities.User user = o.orElseThrow();
//
////        List<GrantedAuthority> authorities = new ArrayList<>();
////        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//        List<GrantedAuthority> authorities = user.getRoles()
//                .stream()
//                .map(r -> new SimpleGrantedAuthority(r.getName()))
//                .collect(Collectors.toList());
//        return new User(user.getUsername(), user.getPassword(), true,true,true,true, authorities);
//    }
//}


@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.example.backendusersapp.models.entities.User> o = repository
                .getUserByUsername(username);

        if (!o.isPresent()) {
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema!", username));
        }
        com.example.backendusersapp.models.entities.User user = o.orElseThrow();

        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);

    }

}
