package com.hua.gr.DS_Assignment;

import com.hua.gr.DS_Assignment.ApplicationForm;

import javax.persistence.*;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "afm")
    private int AFM;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "military_number")
    private String militaryNumber;

    @Column(name = "file")
    private String file;

    @Column(name = "reason_of_postpone")
    private String reasonOfPostpone;

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Citizen() {
    }

    public Citizen(String firstName, String lastName, String email, int phoneNumber, int AFM, String placeOfBirth, String dateOfBirth, String militaryNumber, String file, String reasonOfPostpone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.AFM = AFM;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.militaryNumber = militaryNumber;
        this.file = file;
        this.reasonOfPostpone = reasonOfPostpone;
        //There is no id because it has AUTO
    }

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
        //TODO Search if form is already submitted
        ApplicationForm applicationForm = new ApplicationForm(this);
        //TODO submit form
        return true;
    };

    public boolean search() {
        //TODO
        return true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" +phoneNumber+ ", AFM=" +AFM+ ", placeOfBirth=" +placeOfBirth+ ", dateOfBirth=" +dateOfBirth+ ", militaryNumber=" + militaryNumber+ ", file=" +file+ ", reasonOfPostpone=" +reasonOfPostpone+ ", id=" +id+ "]";
    }
}
