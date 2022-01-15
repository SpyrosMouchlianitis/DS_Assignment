package com.hua.gr.DS_Assignment;

import com.sun.xml.bind.v2.TODO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RestController
public class CitizenController {

//http://localhost:8080/citizens/new?firstName=Apostolis&lastName=Dimitriou&email=it219138@hua.gr&phoneNumber=6939228633&afm=123456&placeOfBirth=Athens&dateOfBirth=04-02-2001&militaryNumber=18&file=name.txt&reasonOfPostpone=idk


    //Insert new user in database
    @GetMapping("/citizens/new")
    public  void insertNewCitizen(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                                  @RequestParam Integer phoneNumber, @RequestParam int afm, @RequestParam String placeOfBirth,
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

        Citizen citizen = new Citizen("Apostolis", "Dimitriou", "spirosgsaaa@gmail.com", 1234, 21958, "Athens", "20/08/2001", "123456789", "file.txt", "Why");

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


}
