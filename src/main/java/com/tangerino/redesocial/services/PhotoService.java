package com.tangerino.redesocial.services;

import com.tangerino.redesocial.entity.Photo;
import com.tangerino.redesocial.entity.PhotoAlbum;
import com.tangerino.redesocial.entity.Post;
import com.tangerino.redesocial.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository repository;

    public Photo savePhoto(MultipartFile photo, PhotoAlbum photoAlbum, Post post) {
        try {
            return repository.save(Photo.builder().bytePhoto(photo.getBytes())
                    .photoAlbum(photoAlbum)
                    .post(post)
                    .build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Photo> saveAllPhotoInPost(List<MultipartFile> photos, Post post) {
        List<Photo> photoList = new ArrayList<>();
        photos.forEach(p -> {
            photoList.add(this.savePhoto(p, null, post));
        });
        return photoList;
    }

    public List<Photo> saveAllPhotoInAlbum(List<MultipartFile> photos, PhotoAlbum photoAlbum) {
        List<Photo> photoList = new ArrayList<>();
        photos.forEach(p -> {
            photoList.add(this.savePhoto(p, photoAlbum, null));
        });
        return photoList;
    }

}
