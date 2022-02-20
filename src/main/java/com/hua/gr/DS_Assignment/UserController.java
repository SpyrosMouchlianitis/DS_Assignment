package com.hua.gr.DS_Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

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


    @RequestMapping("/user/update")
    public void updateUser(@RequestParam int id,@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                            @RequestParam String permission){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(UserCatalog.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            String query1 = "update UserCatalog u set u.firstName = :firstName" +
                    " ,u.lastName = :lastName " +
                    " ,u.email = :email " +
                    " ,u.authority = :authority " +
                    "where u.id = :id";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("firstName", firstName);
            finalQuery.setParameter("lastName", lastName);
            finalQuery.setParameter("email", email);
            finalQuery.setParameter("authority", permission);


            finalQuery.setParameter("id", id);

            finalQuery.executeUpdate();
            session.getTransaction().commit();
        }

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserCatalog>> users() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(UserCatalog.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<UserCatalog> users = session.createQuery("from UserCatalog").getResultList();

            session.getTransaction().commit();
            return ResponseEntity.ok(users);
        }finally {
            factory.close();
        }
    }



}
