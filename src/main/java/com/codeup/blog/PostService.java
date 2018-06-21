package com.codeup.blog;

import com.codeup.blog.Repositories.PostRepository;
import com.codeup.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostService {

    private PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private List<Post> posts;

//    public PostService() {
//        posts = new ArrayList<>();
//        createPosts();
//    }

    public List<Post> findAll() {
        return posts;
    }

//    public static Post save(Post post) {
//        post.setId((posts.size() + 1));
//        posts.add(post);
//        return post;
//    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

//    private void createPosts() {
//        Post post1 = new Post( 1, "Post 1", "Some stuff about post 1");
//        Post post2 = new Post(2, "Post 2", "Some stuff about post 2");
//        Post post3 = new Post(3, "Post 3", "Some stuff about post 3");
//        save(post1);
//        save(post2);
//        save(post3);
//    }
}
