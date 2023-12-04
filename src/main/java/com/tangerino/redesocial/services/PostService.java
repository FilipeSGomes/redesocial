package com.tangerino.redesocial.services;

import com.tangerino.redesocial.entity.Post;
import com.tangerino.redesocial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RelationNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserService userService;
    private final PhotoService photoService;
    private final PostRepository repository;

    public void createPost(String message, String link, List<MultipartFile> photos) {
        Post post = save(Post.builder()
                .user(userService.findUserLogged())
                .link(link)
                .message(message)
                .build());
        photoService.saveAllPhotoInPost(photos, post);
    }


    public List<Post> findAllPost() {
        return repository.findAll();
    }

    public void alterPost(Post post) throws RelationNotFoundException {
        validPostAndUserForAlterAndDelete(post.getId());
        this.save(post);
    }

    public void deletePost(Long idPost) throws RelationNotFoundException {
        Post post = validPostAndUserForAlterAndDelete(idPost);
        repository.delete(post);
    }

    private Post validPostAndUserForAlterAndDelete(Long idPost) {
        Optional<Post> post = findPostByID(idPost);
        try {
            if (post.isEmpty()) {
                throw new RelationNotFoundException("POST is Not Exist");
            }
            if (userService.validUserPermission(post.get().getUser())) {
                throw new AccessDeniedException("User not is owner of Post");
            }
        } catch (RelationNotFoundException e) {
            throw new RuntimeException(e);
        }
        return post.get();
    }

    public Optional<Post> findPostByID(Long idPost) {
        return repository.findById(idPost);
    }


    private Post save(Post post) {
        return repository.save(post);
    }

}
