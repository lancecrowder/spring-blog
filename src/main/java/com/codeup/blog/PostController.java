package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(){
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String aPost(){
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
}
