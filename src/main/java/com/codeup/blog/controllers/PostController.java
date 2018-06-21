package com.codeup.blog.controllers;

import com.codeup.blog.PostService;
import com.codeup.blog.Repositories.PostRepository;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model view){
//        List<Post> aListOfPosts = makeSomePosts();
        view.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable Long id, Model view){
//        Post post = new Post(id, "Imma Post", "Ema Nymton");
//        view.addAttribute("favoriteNumber", postService.getFavoriteNumber());
        view.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @PostMapping("/posts/{id}/edit")
        public String EditPost(@PathVariable long id, Model view){
        Post existingPost = postDao.findOne(id);
        postDao.save(existingPost);
//        view.addAttribute("post", existingPost);
//        System.out.println("Post is: " + existingPost);
        return "/posts/edit";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model view) {
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }


//    private List<Post> makeSomePosts() {
//        return Arrays.asList(
//            new Post("Title 1", "Body 1"),
//            new Post("Title 2", "Body 2")
//        );
//    }
}