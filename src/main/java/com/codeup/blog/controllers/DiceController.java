package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String play(@PathVariable int n, Model model) {
        int number = (int )(Math.random() * 6 + 1);
        boolean result = (n == number);
        model.addAttribute("result", result);
        model.addAttribute("number", number);
        return "dice-rolled";
    }

}