package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JamesHartanto on 4/12/17.
 */
@Controller
public class LeaderboardController {

    @Autowired
    LeaderboardRepo repo;

    @RequestMapping("/leaderboard")
    public String leaderboardResults(Model model){
        model.addAttribute("leaderboard",repo.listTopTen());
        return "leaderboard";
    }
}
