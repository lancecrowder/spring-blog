package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String index(Model view){
        List<Post> aListOfPosts = makeSomePosts();
        view.addAttribute("posts", postService.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view){
        Post post = new Post(id, "Imma Post", "Ema Nymton");
//        view.addAttribute("favoriteNumber", postService.getFavoriteNumber());
        view.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
        public @ResponseBody String EditPost(@PathVariable Long id){
        return String.format("<h1>View form to edit Post #: %s!</h1>", id);
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model view) {
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    private List<Post> makeSomePosts() {
        return Arrays.asList(
            new Post("Title 1", "Body 1"),
            new Post("Title 2", "Body 2")
        );
    }
}
