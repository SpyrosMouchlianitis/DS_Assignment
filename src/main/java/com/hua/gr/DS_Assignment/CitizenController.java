package com.hua.gr.DS_Assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CitizenController {

    @GetMapping("/citizen")
    public  String index() {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Users");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();



        //Return all  users
        Citizen citizen = new Citizen();
        citizen.setFirstName("Spyros");
        citizen.setLastName("Mouchlianitis");
        citizen.setEmail("spiros@gmail.com");
        citizen.setPhoneNumber(1234);
        citizen.setAFM(21958);
        citizen.setPlaceOfBirth("Athens");
        citizen.setDateOfBirth("20/08/2001");
        citizen.setMilitaryNumber("123456");
        citizen.setFile("file.txt");
        citizen.setReasonOfPostpone("Why not");
        citizen.setId(1);

        em.persist(citizen);
        em.getTransaction().commit();
        emf.close();
        em.close();




        return citizen.toString();
    }


}
