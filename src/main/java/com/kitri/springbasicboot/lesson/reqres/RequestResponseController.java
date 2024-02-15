package com.kitri.springbasicboot.lesson.reqres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/countries")
public class RequestResponseController {
//    static HashMap<String,String> countries = new HashMap<>();
//    static {
//        countries.put("한국","서울");
//        countries.put("미국","워싱턴DC");
//        countries.put("프랑스","파리");
//        countries.put("몽골","울란바도르");
//        countries.put("아르헨티나","부에노스아이레스");
//    }
    static HashMap<String,Country> countries = new HashMap<>();
    static {
        countries.put("한국",new Country("한국","서울"));
        countries.put("미국",new Country("미국","워싱턴DC"));
        countries.put("프랑스",new Country("프랑스","파리"));
        countries.put("몽골",new Country("몽골","울란바도르"));
        countries.put("아르헨티나",new Country("아르헨티나","부에노스아이레스"));
    }
    @GetMapping("/{name}")
    public String searchCapital(@PathVariable String name, Model model){
        String capital = countries.get(name).getCapital();
        if(capital == null){
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("country",name);
        model.addAttribute("capital",capital);
        return "/lesson/reqres/country";
    }

    @GetMapping("/searchCapital")
    public String searchCapital2(@RequestParam(defaultValue = "한국") String name, Model model){
        String capital = countries.get(name).getCapital();
        if(capital == null){
            throw new RuntimeException("찾으려는 국가가 없습니다.");
        }
        model.addAttribute("country",name);
        model.addAttribute("capital",capital);
        return "/lesson/reqres/country";
    }

    @PostMapping("/addCountry")
    public String addCountry(@RequestParam String name, @RequestParam String capital){
        countries.put(name,new Country(name,capital));
        return "redirect:/countries/searchCapital?name=" + name;
    }

    @PostMapping("/addCountry2")
    public String addCountry2(@RequestBody Country country){
        countries.put(country.getName(),country);
        return "redirect:/countries/searchCapital?name=" + country.getName();
    }

    @PostMapping("/addCountry3")
    public String addCountry3(@ModelAttribute Country country){
        countries.put(country.getName(),country);
        return "redirect:/countries/searchCapital?name=" + country.getName();
    }
}
