package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * Created by JamesHartanto on 4/12/17.
 */
@Controller
public class LoginController {

    @Autowired
    LeaderboardRepo repo;

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    // Hello / Welcome
    @RequestMapping("/Welcome")
    public String welcomePage(Model model, String name, String description, String age){
        // Uses the input from the login page
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("description",description);

        return "Welcome";
    }

    // Save
    @RequestMapping("/save")
    public String savePlayer(Player player) throws SQLException {
        repo.insertData(player);
        return "redirect:/results";
    }

    // Results
    @RequestMapping("/results")
    public String leaderboardResults(Model model,String name) throws SQLException {
        model.addAttribute("leaderboard",repo.listTopTen());
        model.addAttribute("filter",repo.filterData(name));
        return "leaderboard";
    }

}
