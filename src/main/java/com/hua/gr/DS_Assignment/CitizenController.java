package com.hua.gr.DS_Assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RestController
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @GetMapping("/citizen")
    public  String index() {

        Citizen citizen = new Citizen("Tolis", "Mouchlianitis", "spirosgsaaa@gmail.com", 1234, 21958, "Athens", "20/08/2001", "123456789", "file.txt", "Why", 2);

        citizenRepository.save(citizen);

        System.out.println(citizenRepository.findByFirstName("Spyros"));

        return citizenRepository.findAll().toString();
    }


}
