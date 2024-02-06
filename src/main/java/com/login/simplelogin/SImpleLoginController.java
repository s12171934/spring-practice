package com.login.simplelogin;

import com.login.simplelogin.dto.LoginForm;
import com.login.simplelogin.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.Session;
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
    public String loginForm(){
        return "redirect:/login.html";
    }
    @GetMapping("/signup")
    public String signUpForm(){
        return "redirect:/signup.html";
    }
    @PostMapping("")
    public String login(@Valid LoginForm loginForm, Errors errors, HttpServletRequest request){
        boolean isFail = errors.hasErrors()
                || !memberList.containsKey(loginForm.getEmail())
                || !memberList.get(loginForm.getEmail()).getPassword().equals(loginForm.getPassword());
        if(isFail){
            return "redirect:/login-fail.html";
        } else{
            HttpSession session = request.getSession();
            session.setAttribute("member",memberList.get(loginForm.getEmail()));
            return "redirect:/after-login.html";
        }
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
            return "redirect:/signup-success.html";
        }
    }
}
