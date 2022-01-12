package com.hua.gr.DS_Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Citizen")
public class Citizen {
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private int AFM;
    private String placeOfBirth;
    private String dateOfBirth;
    private String militaryNumber;
    private String file;
    private String reasonOfPostpone;
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAFM() {
        return AFM;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMilitaryNumber() {
        return militaryNumber;
    }

    public void setMilitaryNumber(String militaryNumber) {
        this.militaryNumber = militaryNumber;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getReasonOfPostpone() {
        return reasonOfPostpone;
    }

    public void setReasonOfPostpone(String reasonOfPostpone) {
        this.reasonOfPostpone = reasonOfPostpone;
    }

    public boolean submitForm() {
        //TODO
        return true;
    };

    public boolean search() {
        //TODO
        return true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
