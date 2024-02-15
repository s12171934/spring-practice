package com.kitri.springbasic.di;

public class AirlineService {

    Greeting greeting;

    public AirlineService(Greeting greeting) {
        this.greeting = greeting;
    }

    public String welcome() {

        return greeting.helloFromAirline();

    }

}