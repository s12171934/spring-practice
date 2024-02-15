package com.kitri.springbasicboot.project.randomColor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.LongStream;


@Controller
@RequestMapping("/random")
public class randomController {
    @GetMapping("/color")
    public String randomColor(Model model){
        String color = "#";
        for (int i = 0; i < 3; i++) color += Integer.toHexString((int)(Math.random() * 256));
        model.addAttribute("color",color);
        return "/project/random/randomColor";
    }

    @GetMapping("/number/{num}")
    public String randomNumber(@PathVariable Long num, Model model){
        model.addAttribute("number",(long)(Math.random() * (num - 1)) + 1);
        return "/project/random/randomNumber";
    }
}
