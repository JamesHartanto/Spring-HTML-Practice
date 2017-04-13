package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JamesHartanto on 4/12/17.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
