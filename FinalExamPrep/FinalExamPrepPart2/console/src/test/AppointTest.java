package test;

import lib.HRdepartment;
import lib.Manager;
import lib.Staff;
import lib.StaffAppointHandler;

import java.util.Arrays;
import java.util.Random;

public class AppointTest {
    public static void main(String[] args) {
        Random random = new Random();
        double salary = random.nextInt(3000 * 100, (5000 * 100) + 1) / 100.0;
        Manager boss = new Manager("Manager", salary, "Invoices");

        Staff[] candidates = new Staff[] {
                new Staff ("Staff 1", random.nextInt(3000 * 100, (5000 * 100) + 1) / 100.0, "Candidate"),
                new Staff ("Staff 2", random.nextInt(3000 * 100, (5000 * 100) + 1) / 100.0, "Candidate")
        };

        System.out.printf("Manager: %s\n", boss);
        System.out.printf("Candidates: %s\n", Arrays.toString(candidates));

        HRdepartment hRdepartment = new HRdepartment(boss);
        StaffAppointHandler sah = hRdepartment.getAppointHandler();
        hRdepartment.getManager().addStaffAppointHandler(sah);

        boss.onStaffAppoint(candidates[0], 1300);
        boss.onStaffAppoint(candidates[1], 1500);

        System.out.printf("Result: %s\n", sah.toString());
        System.out.printf("Candidates after result: %s\n", Arrays.toString(candidates));
    }
}
