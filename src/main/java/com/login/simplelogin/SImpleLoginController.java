package com.login.simplelogin;

import com.login.simplelogin.dto.Member;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/login")
public class SImpleLoginController {
    static HashMap<String,Member> memberList = new HashMap<>();

    @GetMapping("")
    public String LoginForm(){
        return "redirect:/login.html";
    }
    @GetMapping("/signup")
    public String signUpForm(){
        return "redirect:/signup.html";
    }

    @PostMapping("/signup")
    public String signUp(@Valid Member member, Errors errors){
        boolean isFail = errors.hasErrors()
                || memberList.containsKey(member.getEmail())
                || !member.getPassword().equals(member.getPasswordCheck());

        if(isFail){
            return "redirect:/login/signup";
        } else{
            memberList.put(member.getEmail(),member);
            return "redirect:/login";
        }
    }
}
