package com.rsp.rockscissorpaper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rsp")
public class RockScissorPaperController {
    @PostMapping
    public Result calculateWinner(@RequestBody Round round, HttpServletRequest req){
        String you;
        String computer;
        if(round.getYou().contains("rock")){
            you = "rock";
        } else if(round.getYou().contains("scissors")){
            you = "scissors";
        } else{
            you = "paper";
        }
        if(round.getComputer().contains("rock")){
            computer = "rock";
        } else if(round.getComputer().contains("scissors")){
            computer = "scissors";
        } else{
            computer = "paper";
        }

        HttpSession session = req.getSession();
        Result result = getSessionOrDefault(session);
        if(you.equals(computer)){
            result.setDraw(result.getDraw() + 1);
        } else if((you.equals("rock") && computer.equals("scissors"))
                ||(you.equals("scissors") && computer.equals("paper"))
                ||(you.equals("paper") && computer.equals("rock"))){
            result.setWinner("#you");
            result.setWin(result.getWin() + 1);
        } else {
            result.setWinner("#computer");
            result.setLose(result.getLose() + 1);
        }
        session.setAttribute("session",result);
        return result;
    }

    @GetMapping
    public Result refresh(HttpServletRequest req, HttpServletResponse resp){
        return getSessionOrDefault(req.getSession());
    }

    public Result getSessionOrDefault(HttpSession session){
        Result result = new Result(null,0,0,0);
        if(session.getAttribute("session") != null){
            result = (Result)session.getAttribute("session");
        }
        return result;
    }
}
