package com.example.pharmacy;

public class DrugRequestDTO {
    private String name;
    private double verkaufspreis;
    private double dosis;
    private Integer categoryId;
    private Integer companyId;


    public DrugRequestDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVerkaufspreis() {
        return verkaufspreis;
    }

    public void setVerkaufspreis(double verkaufspreis) {
        this.verkaufspreis = verkaufspreis;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
