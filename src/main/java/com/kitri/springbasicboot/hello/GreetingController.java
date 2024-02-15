package com.kitri.springbasicboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    Greeting greeting;
    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", greeting.hello());
        return "greeting";
    }
}