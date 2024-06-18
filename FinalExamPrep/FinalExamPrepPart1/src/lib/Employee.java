package lib;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        setName(name);
        setSalary(salary);
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "No Name";
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 1000;
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Salary: %.2f", name, salary);
    }
}
