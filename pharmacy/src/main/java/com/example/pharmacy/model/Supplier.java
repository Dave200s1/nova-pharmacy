package com.example.pharmacy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {
    @Id
    private Integer supplierID;

    private String name;

    private String adress;

    private String cityCode;

    private boolean isActive;

    private int tel;

    private int deliveryInDays;

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDeliveryInDays() {
        return deliveryInDays;
    }

    public void setDeliveryInDays(int deliveryInDays) {
        this.deliveryInDays = deliveryInDays;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", isActive=" + isActive +
                ", tel=" + tel +
                ", deliveryInDays=" + deliveryInDays +
                '}';
    }
}
