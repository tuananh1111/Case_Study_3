package model;

import java.io.Serializable;

public class Supplement implements Serializable {
    private int id;
    private String name;
    private String image;
    private double mass;
    private double price;
    private Company company;
    private TypeOfSupplement type;

    public Supplement(int id, String name, String image, double mass, double price, Company company, TypeOfSupplement type) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.mass = mass;
        this.price = price;
        this.company = company;
        this.type = type;
    }

    public Supplement(String name, String image, double mass, double price, Company company, TypeOfSupplement type) {
        this.name = name;
        this.image = image;
        this.mass = mass;
        this.price = price;
        this.company = company;
        this.type = type;
    }

    public Supplement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public TypeOfSupplement getType() {
        return type;
    }

    public void setType(TypeOfSupplement type) {
        this.type = type;
    }
}
