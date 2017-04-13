package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JamesHartanto on 4/12/17.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/Welcome")
//    public String welcomePage(Model model, Player player){
    public String welcomePage(Model model, String name, String description, String age){
        // Uses the input from the login page
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("description",description);

        return "Welcome";
    }
}
