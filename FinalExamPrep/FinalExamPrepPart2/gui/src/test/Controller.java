package test;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lib.HRdepartment;
import lib.Manager;
import lib.Staff;
import lib.StaffAppointHandler;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAppoint;

    @FXML
    private Button btnList;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnShowStaff;

    @FXML
    private TextArea txaResult;

    private Manager boss;

    private HRdepartment hRdepartment;

    private Random random;

    private Staff[] candidates;

    private StaffAppointHandler sah;

    @FXML
    void btnAppointOnAction(ActionEvent event) {
        boss.onStaffAppoint(candidates[0], 1300);
        boss.onStaffAppoint(candidates[1], 1500);
    }

    @FXML
    void btnListOnAction(ActionEvent event) {
        candidates = new Staff[] {
                new Staff ("Staff 1", random.nextInt(3000 * 100, (5000 * 100) + 1) / 100.0, "Candidate"),
                new Staff ("Staff 2", random.nextInt(3000 * 100, (5000 * 100) + 1) / 100.0, "Candidate")
        };

        txaResult.setText(" ");
        txaResult.appendText(String.format("Manager: %s\n", boss));
        txaResult.appendText(String.format("Candidates: %s\n", Arrays.toString(candidates)));
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnShowStaffOnAction(ActionEvent event) {
        txaResult.setText(" ");
        txaResult.appendText(String.format("Result: %s\n", sah.toString()));
    }

    @FXML
    void initialize() {
        assert btnAppoint != null : "fx:id=\"btnAppoint\" was not injected: check your FXML file 'view.fxml'.";
        assert btnList != null : "fx:id=\"btnList\" was not injected: check your FXML file 'view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'view.fxml'.";
        assert btnShowStaff != null : "fx:id=\"btnShowStaff\" was not injected: check your FXML file 'view.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'view.fxml'.";

        random = new Random();
        double salary = random.nextInt(3000 * 100, (5000 * 100) + 1) / 100.0;
        boss = new Manager("Manager", salary, "Invoices");

        hRdepartment = new HRdepartment(boss);
        sah = hRdepartment.getAppointHandler();
        hRdepartment.getManager().addStaffAppointHandler(sah);

    }

}


