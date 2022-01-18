package com.hua.gr.DS_Assignment;

import com.sun.jdi.event.ExceptionEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_catalog")
public class UserCatalog {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //Employee has number 0
    //Boss has number 1
    @Column(name = "permission")
    private Integer permission;

    @Column(name = "enable")
    private Integer enable;

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        try {
            this.permission = permission;
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
}
