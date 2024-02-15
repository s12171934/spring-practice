package com.kitri.springbasic.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/application.xml");
        AirlineService airlineService = context.getBean("airlineService", AirlineService.class);
        HotelService hotelService = context.getBean("hotelService", HotelService.class);

        System.out.println(airlineService.welcome());
        System.out.println(hotelService.welcome());

    }

}