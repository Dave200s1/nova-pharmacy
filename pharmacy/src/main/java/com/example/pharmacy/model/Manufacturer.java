package com.example.pharmacy.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manufacturer {
    @Id
    private Integer companyID;

    private String name;

    private String adresse;

    public Manufacturer(){}


    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int input ){
        companyID = input;
    }

    public String getName() {
        return name;
    }

    public void setName(String input) {
        name = input;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String input) {
        adresse = input;
    }

    @Override
    public String toString(){
        return "Manufacturer{" +
                "CompanyID" + companyID +
                ", Name = " + name + "\n" +
                ", Adresse = " + adresse + "\n" +
                "}";
    }
}
