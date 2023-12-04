package com.tangerino.redesocial.services;

import com.tangerino.redesocial.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PostService {

private final UserService userService;
    public void createPost(String message, String link, MultipartFile file){

        User userDetails = userService.findUserLogged();
    }

}
