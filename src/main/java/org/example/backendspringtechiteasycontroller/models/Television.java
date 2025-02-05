package org.example.backendspringtechiteasycontroller.models;

public class Television {
    private static int id;
    private String brand;
    private String model;
    private double price;

    public Television(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Television.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
