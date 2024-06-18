package lib;

import java.security.InvalidParameterException;

public class StaffAppointEventArgs {

    private Staff staff;
    private double appointSalary;

    public StaffAppointEventArgs(Staff staff, double appointSalary) {
        setStaff(staff);
        setAppointSalary(appointSalary);
    }

    public Staff getStaff() {
        return new Staff(staff.getName(), staff.getSalary(), staff.getWorkAt());
    }

    public double getAppointSalary() {
        return appointSalary;
    }

    private void setStaff(Staff staff) {
        if (staff == null) {
            throw new InvalidParameterException();
        } else {
            this.staff = new Staff(staff.getName(), staff.getSalary(), staff.getWorkAt());
        }
    }

    private void setAppointSalary(double appointSalary) {
        if (appointSalary > 0) {
            this.appointSalary = appointSalary;
        } else {
            this.appointSalary = 1000;
        }
    }
}
