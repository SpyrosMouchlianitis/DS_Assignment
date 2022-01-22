package com.hua.gr.DS_Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CitizenController {

//http://localhost:8080/citizens/new?firstName=Apostolis&lastName=Dimitriou&email=it219138@hua.gr&phoneNumber=6939228633&afm=123456&placeOfBirth=Athens&dateOfBirth=04-02-2001&militaryNumber=18&file=name.txt&reasonOfPostpone=idk


    //Insert new user in database
    @GetMapping("/citizens/new")
    public  void insertNewCitizen(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                                  @RequestParam String phoneNumber, @RequestParam int afm, @RequestParam String placeOfBirth,
                                  @RequestParam String dateOfBirth, @RequestParam String militaryNumber, @RequestParam String file,
                                  @RequestParam String reasonOfPostpone) {

        //TODO check the phoneNumber problem

        Citizen citizen = new Citizen(firstName, lastName, email,
                phoneNumber, afm, placeOfBirth, dateOfBirth, militaryNumber,
                file, reasonOfPostpone, "Καταχωρημένη");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            session.save(citizen);

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }

    //Print all users in database
    @RequestMapping("/citizens")
    public ResponseEntity<List<Citizen>> citizens() {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Citizen> citizens = session.createQuery("from Citizen").getResultList();

            session.getTransaction().commit();
            return ResponseEntity.ok(citizens);
        }finally {
            factory.close();
        }
    }


}
