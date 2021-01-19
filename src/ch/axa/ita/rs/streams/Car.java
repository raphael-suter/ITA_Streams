package ch.axa.ita.rs.streams;

public class Car {
    private static int lastId = 1;

    public static final int USER_ID = 0;
    public static final int BRAND = 1;
    public static final int MODEL = 2;
    public static final int COLOR = 3;
    public static final int PS = 4;

    private int id;
    private String brand;
    private String model;
    private String color;
    private int ps;

    public Car(String brand, String model, String color, int ps) {
        this.id = generateId();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.ps = ps;
    }

    public int getId() {
        return id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return id + ", " + brand + ", " + model + ", " + color + ", " + ps;
    }

    private static int generateId() {
        return lastId++;
    }
}
