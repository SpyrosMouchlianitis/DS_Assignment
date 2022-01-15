package com.hua.gr.DS_Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
                file, reasonOfPostpone);

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
    @GetMapping("/citizens")
    public  void index() {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Citizen> citizens = session.createQuery("from Citizen").getResultList();

            System.out.println("all");

            for (Citizen c : citizens) {
                System.out.println(c.getFirstName());
            }

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }


}
