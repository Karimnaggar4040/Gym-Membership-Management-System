package frontend;

import backend.Backend;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class CancelRegistration {
    protected static void cancel(){
        Stage stage = new Stage();
        stage.setTitle("Cancel Registration");
        stage.setResizable(false);

        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTextField = new TextField();
        Label classIdLabel = new Label("Class");
        TextField classIdTextField = new TextField();
        Button cancelButton = new Button("Cancel Registration");
        cancelButton.getStyleClass().add("Action-Button");
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("Action-Button");
        backButton.setOnAction(e -> {
            stage.close();
            TrainerMenu.menu();
        });
        cancelButton.setOnAction(e -> {

            String memberId = memberIdTextField.getText();
            String classId = classIdTextField.getText();

            if (memberId.isEmpty() || classId.isEmpty()){
                AlertBox.display("Invalid Data","Empty fields error, please try again");
                return;
            }
            if (!Validations.validateMemberId(memberId)){
                AlertBox.display("Invalid Member ID","Invalid Member ID");
                return;
            }
            if (!Validations.validateClassId(classId)){
                AlertBox.display("Invalid Class ID","Invalid Class ID");
                return;
            }
            if (Backend.searchForMemberRegistrations(memberId+classId) == null){
                AlertBox.display("Invalid Registration","Registration not found");
                return;
            }
           boolean confirmation = Backend.cancelClassRegistration(memberId, classId);
            if (!confirmation){
                AlertBox.display("Invalid Registration","Could not remove Registration");
                return;
            }
            MessageBox.display("Cancellation Successful","Member With ID: "+memberId+" has cancelled the registration to class with ID: "+classId);
            stage.close();
            TrainerMenu.menu();
        });
        GridPane grid = TrainerRoleLogin.createGridPane();
        grid.add(memberIdLabel, 0, 0);
        grid.add(memberIdTextField, 1, 0);
        grid.add(classIdLabel, 0, 1);
        grid.add(classIdTextField, 1, 1);
        grid.add(cancelButton, 1, 2);
        grid.add(backButton,0,2);

        Scene scene = new Scene(grid,300,300);
        stage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.show();
    }
}
