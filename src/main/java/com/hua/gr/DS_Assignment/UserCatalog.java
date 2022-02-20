package com.hua.gr.DS_Assignment;

import javax.persistence.*;

@Entity
@Table(name = "user_catalog")
public class UserCatalog {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //Employee has number 0
    //Boss has number 1
    @Column(name = "authority")
    private String authority;



    @Column(name = "enabled")
    private Integer enabled ;



    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getPermission() {
        return authority;
    }

    public void setAuthority(String authority) {
        try {
            this.authority = authority;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        try {
            this.firstName = firstName;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        try {
            this.lastName = lastName;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            this.email = email;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = password;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public boolean approve() {
        //TODO
        return true;
    }


    public Integer getEnabled() {
        return enabled ;
    }

    public void setEnabled(Integer enable) {
        this.enabled  = enable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
