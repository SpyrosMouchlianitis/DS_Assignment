package com.hua.gr.DS_Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RestController
public class CitizenController {



    @GetMapping("/citizen")
    public  void index() {

        Citizen citizen = new Citizen("Apostolis", "Dimitriou", "spirosgsaaa@gmail.com", 1234, 21958, "Athens", "20/08/2001", "123456789", "file.txt", "Why");

        //citizenRepository.save(citizen);

        //System.out.println(citizenRepository.findByFirstName("Spyros"));

        //return citizenRepository.findAll().toString();

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
