package com.hua.gr.DS_Assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CitizenController {

    @GetMapping("/citizen")
    public  String index() {

        //Return all  users
        List<Citizen> citizens = new ArrayList<>();
        citizens.add(new Citizen("Spyros", "Mouchlianitis", "spiros@gmail.com", 1234, 21958, "Athens", "20/08/2001", "123456", "file.txt", "Why not", 1));
        citizens.add(new Citizen("Tolis", "Dimitriou", "aposdimit@gmail.com", 4321, 219138, "Athens", "02/02/2001", "123456789", "file1.txt", "Because!", 2));
        return citizens.toString();
    }
}
