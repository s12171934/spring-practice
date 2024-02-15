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
        int you;
        int computer = Integer.parseInt(round.getComputer());
        if(round.getYou().contains("rock")){
            you = 0;
        } else if(round.getYou().contains("scissors")){
            you = 1;
        } else{
            you = 2;
        }

        HttpSession session = req.getSession();
        Result result = getSessionOrDefault(session);
        if(you == computer){
            result.setDraw(result.getDraw() + 1);
        } else if((you == 0 && computer == 1)
                ||(you == 1 && computer == 2)
                ||(you == 2 && computer == 0)){
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
