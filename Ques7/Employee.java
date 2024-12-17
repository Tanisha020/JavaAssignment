// Employee class
public class Employee {
    private int id;
    private String name;
    private double salary;

    // Default constructor
    public Employee() {
        this.id = 0;
        this.name = "Default name";
        this.salary = 0.0;
    }

    // constructor with all fields
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Constructor with name and id
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.salary = 0.0;
    }

    // Constructor with id only
    public Employee(int id) {
        this.id = id;
        this.name = "Default name";
        this.salary = 0.0;
    }

    //constructor with name only
    public Employee(String name) {
        this.id = 0;
        this.name = name;
        this.salary = 0.0;
    }

    //getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getter and setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method
    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nSalary: " + salary;
    }
}