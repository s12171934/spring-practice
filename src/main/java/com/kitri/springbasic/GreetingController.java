package com.kitri.springbasic;

import com.kitri.springbasic.di.AirlineService;
import com.kitri.springbasic.di.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
    public GreetingController(AirlineService airlineService, HotelService hotelService) {
        this.airlineService = airlineService;
        this.hotelService = hotelService;
    }

    @Autowired
    AirlineService airlineService;
    @Autowired
    HotelService hotelService;
    @GetMapping("/greeting")
    @ResponseBody
    public String hello() {
        return airlineService.welcome();
    }
    @GetMapping("/greeting-jsp")
    public String helloJsp(Model model) {
        String welcomeMessage = airlineService.welcome();
        model.addAttribute("welcomeMessage",welcomeMessage);
        return "greeting";
    }

}