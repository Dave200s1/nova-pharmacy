package com.example.pharmacy.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Drug {
    @Id
    private Integer drugID;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Manufacturer companyId;

    //Todo Category ?

    private double verkaufspreis;

    private double dosis;


    public Integer getDrugID() {
        return drugID;
    }

    public void setDrugID(Integer drugID) {
        this.drugID = drugID;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public double getVerkaufspreis() {
        return verkaufspreis;
    }

    public void setVerkaufspreis(double verkaufspreis) {
        this.verkaufspreis = verkaufspreis;
    }

    public Manufacturer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Manufacturer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Drug{" +
                "drugID=" + drugID +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                ", verkaufspreis=" + verkaufspreis +
                ", dosis=" + dosis +
                '}';
    }
}
