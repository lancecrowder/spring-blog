package com.codeup.blog;

import com.codeup.blog.Repositories.UserRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.Repositories.PostRepository;
import com.codeup.blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post save(Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(sessionUser.getId());
        post.setUser(user);
        postRepository.save(post);
        return post;
    }

    public Post findOne(long id) {
        return  postRepository.findOne(id);
    }

    public Post editPost(Post post){
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.delete(id);
    }
}