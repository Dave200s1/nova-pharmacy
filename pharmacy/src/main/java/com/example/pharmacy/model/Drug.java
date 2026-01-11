package com.example.pharmacy.model;


import com.example.pharmacy.repo.CategoryRepo;
import com.example.pharmacy.repo.DrugRepo;


import javax.persistence.*;

@Entity
public class Drug {


    @Id
    private Integer drugID;

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Manufacturer companyId;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;

    private double verkaufspreis;

    private double dosis;

    @Transient
    private Integer categoryIdInput;

    @Transient
    private Integer companyIdInput;

    public Integer getCategoryIdInput() {
        return categoryIdInput;
    }

    public void setCategoryIdInput(Integer categoryIdInput) {
        this.categoryIdInput = categoryIdInput;
    }

    public Integer getCompanyIdInput() {
        return companyIdInput;
    }

    public void setCompanyIdInput(Integer companyIdInput) {
        this.companyIdInput = companyIdInput;
    }
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
                ", categoryId=" + categoryId +
                ", verkaufspreis=" + verkaufspreis +
                ", dosis=" + dosis +
                '}';
    }
}
