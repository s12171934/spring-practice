package com.kitri.springbasicboot.hello;

public class KoreanGreeting implements Greeting {
    @Override
    public String hello() {
        return "안녕 !!!";
    }
}