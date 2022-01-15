package com.hua.gr.DS_Assignment;

public class Employee {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        try {
            this.userName = userName;
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

    public boolean acceptPostpone() {
        //TODO
        return true;
    }
}
