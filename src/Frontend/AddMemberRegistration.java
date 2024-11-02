package Frontend;

import Backend.Backend;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

public class AddMemberRegistration {
    protected static void add() {
        Stage stage = new Stage();
        stage.setTitle("Add Class");
        stage.setResizable(false);
        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTextField = new TextField();
        Label classIdLabel = new Label("Class ID");
        TextField classIdTextField = new TextField();
        Label registrationDateLabel = new Label("Registration Date");
        DatePicker registrationDatePicker = new DatePicker();
        registrationDatePicker.setValue(LocalDate.now());
        Button addClassButton = new Button("Register");
        addClassButton.getStyleClass().add("Action-Button");
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("Action-Button");
        addClassButton.setOnAction(e -> {
            String memberId = memberIdTextField.getText();
            String classId = classIdTextField.getText();
            LocalDate registrationDate = registrationDatePicker.getValue();

            // Validate Member ID
            if (!Validations.validateMemberId(memberId)) {
                AlertBox.display("Invalid Member", "Please enter a valid member ID");
                stage.close();
                add();
                return;
            }

            // Validate that the member exists
            if (Backend.searchForMember(memberId) == null){
                AlertBox.display("Invalid Member", "Member does not exist, please try again");
                stage.close();
                add();
                return;
            }

            // Validate Class ID
            if (!Validations.validateClassId(classId)) {
                AlertBox.display("Invalid Class", "Please enter a valid class ID");
                stage.close();
                add();
                return;
            }

            // Validate that the class exists
            if (Backend.searchForClass(classId) == null){
                AlertBox.display("Invalid Class", "Class does not exist, please try again");
                stage.close();
                add();
                return;
            }

            boolean confirmation = Backend.addMemberRegistration(memberId, classId, registrationDate);
            if (!confirmation){
                AlertBox.display("Registration Error","This registration already exists, please try again");
                stage.close();
                add();
                return;
            }

            // If added successfully
            MessageBox.display("Registration Successful","Member with ID " + memberId + " registered successfully to class " + classId);
            stage.close();
            TrainerMenu.menu();
        });
        backButton.setOnAction(e -> {
            stage.close();
            TrainerMenu.menu();
        });

        GridPane grid = TrainerRoleLogin.createGridPane();
        grid.add(memberIdLabel,0,0);
        grid.add(memberIdTextField,1,0);
        grid.add(classIdLabel,0,1);
        grid.add(classIdTextField,1,1);
        grid.add(registrationDateLabel,0,2);
        grid.add(registrationDatePicker,1,2);
        grid.add(addClassButton,1,3);
        grid.add(backButton,0,3);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
