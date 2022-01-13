package com.hua.gr.DS_Assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    //Url in browser "admin/login?name=[the_email]"&password[user_password]"
    @PostMapping("/admin/login?")
    public void login(@RequestParam String name, @RequestParam String password){

    }

    @GetMapping("/admin/dashboard")
    public void dashboard(){
        //It will send all the data to the front-end for the admin if the login is succesfully
    }

}
