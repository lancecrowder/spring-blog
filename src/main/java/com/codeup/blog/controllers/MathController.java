package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
        public @ResponseBody String Addition(
                @PathVariable int x,
                @PathVariable int y
                ){
        return String.format("The Sum of %d and %d is %d", x, y, x+y);
    }

    @GetMapping("/subtract/{x}/and/{y}")
        public @ResponseBody String Subtraction(
                @PathVariable int x,
                @PathVariable int y
                ){
        return String.format("The Difference of %d and %d is %d", x, y, x-y);
    }

    @GetMapping("/multiply/{x}/and/{y}")
        public @ResponseBody String Multiplication(
                @PathVariable int x,
                @PathVariable int y
                ){
        return String.format("The Product of %d and %d is %d", x, y, x*y);
    }

    @GetMapping("/divide/{x}/and/{y}")
        public @ResponseBody String Division(
                @PathVariable int x,
                @PathVariable int y
                ){
        return String.format("The Quotient of %d and %d is %d", x, y, x/y);
    }
}
