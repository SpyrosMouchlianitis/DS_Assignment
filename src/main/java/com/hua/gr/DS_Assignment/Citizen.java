package com.hua.gr.DS_Assignment;

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
    private String phoneNumber;

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

    public Citizen(String firstName, String lastName, String email, String phoneNumber, int AFM, String placeOfBirth, String dateOfBirth, String militaryNumber, String file, String reasonOfPostpone) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            this.phoneNumber = phoneNumber;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public int getAFM() {
        return AFM;
    }

    public void setAFM(int AFM) {
        try {
            this.AFM = AFM;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        try {
            this.placeOfBirth = placeOfBirth;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            this.dateOfBirth = dateOfBirth;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getMilitaryNumber() {
        return militaryNumber;
    }

    public void setMilitaryNumber(String militaryNumber) {
        try {
            this.militaryNumber = militaryNumber;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        try {
            this.file = file;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public String getReasonOfPostpone() {
        return reasonOfPostpone;
    }

    public void setReasonOfPostpone(String reasonOfPostpone) {
        try {
            this.reasonOfPostpone = reasonOfPostpone;
        } catch (Exception e) {
            //TODO alert user
        }
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
        try {
            this.id = id;
        } catch (Exception e) {
            //TODO alert user
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" +phoneNumber+ ", AFM=" +AFM+ ", placeOfBirth=" +placeOfBirth+ ", dateOfBirth=" +dateOfBirth+ ", militaryNumber=" + militaryNumber+ ", file=" +file+ ", reasonOfPostpone=" +reasonOfPostpone+ ", id=" +id+ "]";
    }
}
