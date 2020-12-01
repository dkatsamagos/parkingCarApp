package com.myWebApp.entities;

/**
 *
 * @author dkats
 */
public class Car {

    // fields
    private int id;
    private String model;
    private String plateNumber;
    private String color;

    //constructor
    public Car() {
    }

    public Car(int id, String model, String plateNumber, String color) {
        this.setId(id);
        this.setModel(model);
        this.setPlateNumber(plateNumber);
        this.setColor(color);
    }

    public Car(String model, String plateNumber, String color) {
        this.setModel(model);
        this.setPlateNumber(plateNumber);
        this.setColor(color);
    }

    //getters-setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // to string
    @Override
    public String toString() {
        return "Car [id=" + id + ", model=" + model + ", plateNumber=" + plateNumber + ", color=" + color + "]";
    }
}
