package lib;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HRdepartment {
    private Manager manager;
    private ArrayList<Staff> staff;

    public HRdepartment(Manager manager) {
        setManager(manager);
        this.staff = new ArrayList<>();
    }

    public Manager getManager() {
        //return new Manager(manager.getName(), manager.getSalary(), manager.getManagerDeptName());
        return manager;
    }

    public void setManager(Manager manager) {
       if (manager == null) {
           throw new InvalidParameterException();
       } else {
           //this.manager = new Manager(manager.getName(), manager.getSalary(), manager.getManagerDeptName());
           this.manager = manager;
       }
    }

   private class StaffAppointHandlerInner implements StaffAppointHandler {
       private String appointDepartment;

       public StaffAppointHandlerInner(String appointDepartment) {
           setAppointDepartment(appointDepartment);
       }

       public String getAppointDepartment() {
           return appointDepartment;
       }

       public void setAppointDepartment(String appointDepartment) {
           if (appointDepartment == null) {
               throw new InvalidParameterException();
           }
               this.appointDepartment = appointDepartment;
       }

       @Override
       public void addStaff(StaffAppointEventArgs event) {
            Staff newStaff = event.getStaff();
            newStaff.setWorkAt(this.appointDepartment);
            newStaff.setSalary(event.getAppointSalary());
            HRdepartment.this.staff.add(newStaff);
       }

       @Override
       public String toString() {
           return String.format("%s, AppointDepartment: %s", HRdepartment.this.toString(), appointDepartment);
       }
   }
   public StaffAppointHandler getAppointHandler() {
        return new StaffAppointHandlerInner(manager.getManagerDeptName());
   }

    @Override
    public String toString() {
        return String.format("Manager: %s, \nStaff: %s", manager,
                staff.stream()
                        //.map(staffElement -> staffElement.toString())
                        .map(Staff::toString)
                        .collect(Collectors.joining("\n"))
        );
    }
}
