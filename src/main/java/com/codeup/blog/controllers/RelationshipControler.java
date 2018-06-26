package com.codeup.blog.controllers;

import com.codeup.blog.Repositories.PostRepository;
import com.codeup.blog.Repositories.UserRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@ResponseBody
@Controller
public class RelationshipControler {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public RelationshipControler(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/seed")
    public String seed(){
        User user = new User();
        user.setEmail("thelancecrowder@gmail.com");
        user.setUsername("lancecrowder");
        user.setPassword("codeup");
        userRepository.save(user);

        List<Post> posts = Arrays.asList(
                new Post("Primary Post", "lorem"),
                new Post("Secondary Post", "lorem"),
                new Post("Tertiary Post", "lorem"),
                new Post("Quaternary Post", "lorem"),
                new Post("Quinary Post", "lorem")
        );

        for(Post post: posts){
            post.setUser(user);
        }
        postRepository.save(posts);
        return "Console!!!";
    }

    @GetMapping("/profile/")
    public String profile(){
        User user = userRepository.findOne((long) 1);

        System.out.println("Posts for User: " + user.getUsername());

        List<Post> posts = user.getPosts();

        for (Post post: posts){
            System.out.println(" -"+post.getTitle());
        }
        return "More Console!!!";
    }

    @GetMapping("/ShowPosts")
    public String show(){
        Post post = postRepository.findOne(1l);
        System.out.println(post.getUser().getEmail());
        return "Console again!!";
    }


}
