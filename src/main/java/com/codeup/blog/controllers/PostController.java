package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Arrays;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model view){
        List<Post> aListOfPosts = makeSomePosts();
        view.addAttribute("posts", aListOfPosts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view){
        Post post = new Post(id, "Imma Post", "Ema Nymton");
        view.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
        public @ResponseBody String EditPost(@PathVariable Long id){
        return String.format("<h1>View form to edit Post #: %s!</h1>", id);
    }

    @GetMapping("/posts/create")
        public @ResponseBody String newPost(){
        return String.format("<form action=\"/posts/create\" method=\"post\">"+
                "<h1>Create a new post!</h1>" +
                "<button type=\"submit\"> Post me! </button>"+
                "</form>");
    }

    @PostMapping("/posts/create")
        public @ResponseBody String newNewPost(){
        return String.format("<h1>I'm posted!</h1>");
    }

    private List<Post> makeSomePosts() {
        return Arrays.asList(
            new Post("Title 1", "Body 1"),
            new Post("Title 2", "Body 2")
        );
    }
}
