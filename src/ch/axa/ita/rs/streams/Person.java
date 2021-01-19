package ch.axa.ita.rs.streams;

public class Person {
    private static int lastId = 1;

    public static final int FIRSTNAME = 0;
    public static final int LASTNAME = 1;
    public static final int HEIGHT = 2;
    public static final int AGE = 3;

    private int id;
    private String firstname;
    private String lastname;
    private double height;
    private int age;
    private Car car;

    public Person(String firstname, String lastname, double height, int age) {
        this.id = generateId();
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return id + ", " + firstname + " " + lastname + ", " + height + "m, " + age + ", " + car;
    }

    private static int generateId() {
        return lastId++;
    }
}
