package com.hua.gr.DS_Assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/user")
    public  String index() {

        //Return all  users
        return "Greetings from Spring Controller";
    }
}
