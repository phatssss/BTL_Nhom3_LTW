package com.javaweb.service.impl;

import com.javaweb.entity.UserEntity;
import com.javaweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
//import java.util.List;
//import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(
                user.getUserName(),
                user.getPassword(),
                user.getStatus() != null || !user.getStatus() ? Collections.emptyList() :
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().getCode().toUpperCase()))
        );

    }
}
