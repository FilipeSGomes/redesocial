package com.tangerino.redesocial.services;

import com.tangerino.redesocial.entity.User;
import com.tangerino.redesocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDetails findByLogin(String login){
        return repository.findByLogin(login);
    }

    public void save(User user){
       repository.save(user);
    }
}
