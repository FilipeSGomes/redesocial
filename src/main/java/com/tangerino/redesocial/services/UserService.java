package com.tangerino.redesocial.services;

import com.tangerino.redesocial.entity.User;
import com.tangerino.redesocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDetails findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public User findUserByLogin(String login) {
        return repository.findUserByLogin(login);
    }
    public void save(User user) {
        repository.save(user);
    }

    public User findUserLogged() {
        return findUserByLogin(capturUserLogin());
    }

    private String capturUserLogin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();

    }
}
