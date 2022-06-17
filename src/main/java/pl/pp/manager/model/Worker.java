package pl.pp.manager.model;

public class Worker {
    private String firstName;
    private String lastName;
    private double salary;

    public Worker(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public Worker setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Worker setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Worker setSalary(double salary) {
        this.salary = salary;
        return this;
    }
}
