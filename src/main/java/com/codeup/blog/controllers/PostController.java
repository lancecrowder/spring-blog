package com.codeup.blog.controllers;

import com.codeup.blog.Repositories.PostRepository;
import com.codeup.blog.Repositories.UserRepository;
import com.codeup.blog.services.PostService;
import com.codeup.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService postSvc;
    private UserRepository userRepository;


    @Autowired
    public PostController(PostService postSvc, UserRepository userRepository) {
        this.postSvc = postSvc;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String index(Model view, @RequestParam(name = "search", required = false) String searchTerm){
//        List<Post> aListOfPosts = makeSomePosts();
        System.out.println("PostController#index");
        List<Post> posts;
        if (searchTerm == null){
            posts = postSvc.findAll();
        } else {
            posts = postSvc.search(searchTerm);
        }
        view.addAttribute("posts", posts);
        view.addAttribute("searchTerm", searchTerm);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable Long id, Model view){
        view.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
        public String EditPost(@PathVariable long id, Model view){
        Post existingPost = postSvc.findOne(id);
        view.addAttribute("post", existingPost);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
        public String UpdatePost(@PathVariable long id, @ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model view) {
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postSvc.deletePost(id);
        return "redirect:/posts";
    }


}