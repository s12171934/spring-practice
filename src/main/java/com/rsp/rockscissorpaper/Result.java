package com.rsp.rockscissorpaper;

public class Result {
    public String winner;
    public int win;
    public int lose;
    public int draw;

    public Result(String winner, int win, int lose, int draw) {
        this.winner = winner;
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }

    public Result() {
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
