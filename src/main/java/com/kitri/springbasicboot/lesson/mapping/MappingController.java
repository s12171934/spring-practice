package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingController {
    @RequestMapping(
            value = {"/a","/b","/c"},
            method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String multiURL(Model model){
        model.addAttribute("message","MULTI_UTL_MAPPING");
        return "/lesson/mapping";
    }

    @PutMapping("/put")
    public String put(Model model){
        model.addAttribute("message","PUT");
        return "/lesson/mapping";
    }
}
