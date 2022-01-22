package com.hua.gr.DS_Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    //user/register?firstName=[firstName]&lastName=[lastName]&email=[email]&password=[password]
    @GetMapping("/user/register")
    public void register(@RequestParam String firstName, @RequestParam String lastName,
                      @RequestParam String email, @RequestParam String password){

        UserCatalog newUser = new UserCatalog();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setAuthority("ROLE_USER");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(UserCatalog.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            session.save(newUser);

            session.getTransaction().commit();


        }finally {
            factory.close();
        }

    }

    @GetMapping("/user/login")
    public void login(@RequestParam String email, @RequestParam String password){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(UserCatalog.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            String query1 = "from UserCatalog u where u.email= :email and u.password= :pass";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("email", email);
            finalQuery.setParameter("pass", password);

            List<UserCatalog> search = finalQuery.getResultList();


            for (UserCatalog u : search) {
                System.out.println(u.getFirstName());
            }

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }

    @GetMapping("/user/delete")
    public void delete(@RequestParam String email){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(UserCatalog.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            String query1 = "from UserCatalog u where u.email= :email";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("email", email);

            List<UserCatalog> search = finalQuery.getResultList();


            for (UserCatalog u : search) {
                System.out.println(u.getFirstName());
            }

            //It needs to print the results to ui and change the inputs

            session.getTransaction().commit();


        }finally {
            factory.close();
        }

    }


    @GetMapping("/user/modify")
    public void modify(@RequestParam String email){


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(UserCatalog.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            String query1 = "from UserCatalog u where u.email= :email";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("email", email);

            List<UserCatalog> search = finalQuery.getResultList();


            for (UserCatalog u : search) {
                System.out.println(u.getFirstName());
            }

            //It needs to print the results to ui and change the inputs

            session.getTransaction().commit();


        }finally {
            factory.close();
        }

    }



}
