package com.kitri.springbasicboot.lesson.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    @PostMapping
    public String makeSession(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        session.setAttribute("id",req.getParameter("id"));
        return (String) session.getAttribute("id");
    }
}
