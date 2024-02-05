package com.rsp.rockscissorpaper;

public class Round {
    String you;
    String computer;

    public Round() {
    }

    public Round(String you, String computer) {
        this.you = you;
        this.computer = computer;
    }

    public String getYou() {
        return you;
    }

    public void setYou(String you) {
        this.you = you;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }
}
