package com.kitri.springbasicboot.lesson.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cookie")
public class CookieController {
    @PostMapping
    public void cookie1(HttpServletRequest req, HttpServletResponse resp){
        Cookie cookie1 = new Cookie("id",req.getParameter("id"));
        resp.addCookie(cookie1);
    }

//    @GetMapping
//    public String readCookie(HttpServletRequest req){
//        Cookie[] cookies = req.getCookies();
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals("id")){
//                return cookie.getValue();
//            }
//        }
//        return null;
//    }
    @GetMapping
    public String readCookie(@CookieValue(name="id", required = false) String id){
        return id;
    }

    @DeleteMapping
    public void deleteCookie(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("id")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
    }
}
