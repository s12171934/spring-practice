package com.kitri.springbasicboot.lesson.valid;

import com.kitri.springbasicboot.lesson.valid.dto.SignUpFromDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/valid")
public class ValidController {
    @GetMapping
    public String from() {
        return "redirect:/valid/form.html";
    }

    @PostMapping
    public String readForm(@Valid SignUpFromDto form) {
        System.out.println(form);

        return "redirect:/valid/success.html";
    }
}