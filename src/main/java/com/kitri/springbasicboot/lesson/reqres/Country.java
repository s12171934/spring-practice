package com.kitri.springbasicboot.lesson.reqres;

public class Country {
    String name;
    String capital;

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
}
