package lib;

import java.security.InvalidParameterException;

public class Manager extends Employee{
    private String managerDeptName;
    private StaffAppointHandler staffAppoint;


    public Manager(String name, double salary, String managerDeptName) {
        super(name, salary);
        setManagerDeptName(managerDeptName);
    }

    public String getManagerDeptName() {
        return managerDeptName;
    }

    public void setManagerDeptName(String managerDeptName) {
        if (managerDeptName == null) {
            throw new InvalidParameterException();
        } else {
            this.managerDeptName = managerDeptName;
        }
    }

    public void addStaffAppointHandler(StaffAppointHandler handler) {
        this.staffAppoint = handler;
    }

    public void onStaffAppoint (Staff member, double newStaffMemberSalary) {
        if(staffAppoint != null) {
            StaffAppointEventArgs event = new StaffAppointEventArgs(member, newStaffMemberSalary);
            staffAppoint.addStaff(event);
        }
    }
    @Override
    public String toString() {
        return String.format("%s, ManagerDeptName: %s", super.toString(), managerDeptName);
    }
}
