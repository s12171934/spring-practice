package com.kitri.springbasic.di;

public class HotelService {

    Greeting greeting;

    public HotelService(Greeting greeting) {
        this.greeting = greeting;
    }

    String welcome() {

        return greeting.helloFromHotel();

    }

}