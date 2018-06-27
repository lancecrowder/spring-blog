package com.codeup.blog.controllers;

import com.codeup.blog.Repositories.PostRepository;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        view.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
        public String EditPost(@PathVariable long id, Model view){
        Post existingPost = postDao.findOne(id);
        view.addAttribute("post", existingPost);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
        public String UpdatePost(@PathVariable long id, @ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
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


}