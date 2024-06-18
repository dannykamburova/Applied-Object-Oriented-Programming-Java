package lib;

import lib.Employee;

public class Staff extends Employee {
    private String workAt;

    public Staff(String name, double salary, String workAt) {
        super(name, salary);
        setWorkAt(workAt);
    }
    public String getWorkAt() {
        return workAt;
    }
    public void setWorkAt(String workAt) {
        if (workAt != null) {
            this.workAt = workAt;
        } else {
            this.workAt = "Candidate";
        }
    }

    @Override
    public String toString() {
        return String.format("%s, WorkAt: %s", super.toString(), workAt);
    }
}
