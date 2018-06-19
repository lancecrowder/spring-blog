package com.codeup.blog;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    private void createPosts() {
        Post post1 = new Post((long) 1, "Post 1", "Some stuff about post 1");
        Post post2 = new Post((long )2, "Post 2", "Some stuff about post 2");
        Post post3 = new Post((long)3, "Post 3", "Some stuff about post 3");
        save(post1);
        save(post2);
        save(post3);
    }
}
