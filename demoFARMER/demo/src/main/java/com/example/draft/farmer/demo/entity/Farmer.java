package com.example.draft.farmer.demo.entity;

import javax.management.Query;

public class Farmer {



    private String FirstName;
    private String LastName;
    private String OilProduct; //Oil, olive paste
    private String cultivationArea;
    private String OrganizationName;

    public Farmer(String firstName, String lastName, String oilProduct, String cultivationArea, String organizationName) {
        FirstName = firstName;
        LastName = lastName;
        OilProduct = oilProduct;
        this.cultivationArea = cultivationArea;
        OrganizationName = organizationName;
    }
    Farmer farmer = new Farmer("Mike","Doe","oil","Megara","OilBreakers");
    //save it to db
    int id = (Integer) session.save(farmer);
    //retrieve from db
    Farmer myFarmer = session.get(Farmer.class, FirstName);
    Query query = session.createQuery("from Farmer");
    List<Farmers> farmers = query.list();

    public Farmer() {

    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getOilProduct() {
        return OilProduct;
    }

    public void setOilProduct(String oilProduct) {
        OilProduct = oilProduct;
    }

    public String getCultivationArea() {
        return cultivationArea;
    }

    public void setCultivationArea(String cultivationArea) {
        this.cultivationArea = cultivationArea;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }


    @Override
    public String toString() {
        return "Farmer{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", OilProduct='" + OilProduct + '\'' +
                ", cultivationArea='" + cultivationArea + '\'' +
                ", OrganizationName='" + OrganizationName + '\'' +
                '}';
    }
}
