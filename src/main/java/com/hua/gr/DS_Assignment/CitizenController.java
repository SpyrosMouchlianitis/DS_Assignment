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
                file, reasonOfPostpone, "K");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            session.save(citizen);

            session.getTransaction().commit();


        }catch (Exception e) {
            System.out.println(e);
        }
    }

    //Print all users for employee
    @RequestMapping("/citizens/employee")
    public ResponseEntity<List<Citizen>> citizensEmployee() {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            String query1 = "from Citizen c where progress = :status";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("status", "K");

            List<Citizen> citizens = finalQuery.getResultList();

            session.getTransaction().commit();
            return ResponseEntity.ok(citizens);
        }finally {
            factory.close();
        }
    }

    //Print all users for admin
    @RequestMapping("/citizens/admin")
    public ResponseEntity<List<Citizen>> citizensAdmin() {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            String query1 = "from Citizen c where progress = :status or progress = :status1";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("status", "KT");
            finalQuery.setParameter("status1", "A");

            List<Citizen> citizensForAdmin = finalQuery.getResultList();

            session.getTransaction().commit();
            return ResponseEntity.ok(citizensForAdmin);
        }finally {
            factory.close();
        }
    }

    @RequestMapping("/citizen/delete")
    public void deleteUser(@RequestParam int id){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            String query1 = "delete from Citizen c where c.id = :index";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("index", id);

            finalQuery.executeUpdate();
            session.getTransaction().commit();
        }

    }

    @RequestMapping("/citizen/accept")
    public void acceptUser(@RequestParam int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            String query1 = "update Citizen c set c.progress = :progress where c.id = :id";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("progress", "KT");
            finalQuery.setParameter("id", id);

            finalQuery.executeUpdate();
            session.getTransaction().commit();
        }

    }

    @RequestMapping("/citizen/final-accept")
    public void finalAcceptUser(@RequestParam int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            String query1 = "update Citizen c set c.progress = :progress where c.id = :id";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("progress", "A");
            finalQuery.setParameter("id", id);

            finalQuery.executeUpdate();
            session.getTransaction().commit();
        }

    }

    @RequestMapping("/citizen/update")
    public void updateUser(@RequestParam int id,@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                           @RequestParam String phoneNumber, @RequestParam int afm, @RequestParam String placeOfBirth,
                           @RequestParam String dateOfBirth, @RequestParam String militaryNumber,
                           @RequestParam String reasonOfPostpone){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Citizen.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            String query1 = "update Citizen c set c.firstName = :firstName" +
                    " ,c.lastName = :lastName " +
                    " ,c.email = :email " +
                    " ,c.phoneNumber = :phoneNumber " +
                    " ,c.AFM = :afm " +
                    " ,c.placeOfBirth = :placeOfBirth " +
                    " ,c.dateOfBirth = :dateOfBirth " +
                    " ,c.militaryNumber = :militaryNumber " +
                    " ,c.reasonOfPostpone = :reasonOfPostpone " +
                    "where c.id = :id";
            Query finalQuery = session.createQuery(query1);
            finalQuery.setParameter("firstName", firstName);
            finalQuery.setParameter("lastName", lastName);
            finalQuery.setParameter("email", email);
            finalQuery.setParameter("phoneNumber", phoneNumber);
            finalQuery.setParameter("afm", afm);
            finalQuery.setParameter("placeOfBirth", placeOfBirth);
            finalQuery.setParameter("dateOfBirth", dateOfBirth);
            finalQuery.setParameter("militaryNumber", militaryNumber);
            finalQuery.setParameter("reasonOfPostpone", reasonOfPostpone);

            finalQuery.setParameter("id", id);

            finalQuery.executeUpdate();
            session.getTransaction().commit();
        }

    }


}
