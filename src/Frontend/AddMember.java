package Frontend;

import Backend.Backend;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class AddMember {
    protected static void add() {
        Stage stage = new Stage();
        stage.setTitle("Add Member");
        stage.setResizable(false);

        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTextField = new TextField();
        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();
        Label membershipTypeLabel = new Label("Membership Type");
        ComboBox<String> membershipTypeComboBox = new ComboBox<>();
        membershipTypeComboBox.getItems().addAll("Weekly", "Monthly", "Yearly");
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        Label phoneNumberLabel = new Label("Phone Number");
        TextField phoneNumberTextField = new TextField();
        Label statusLabel = new Label("Status");
        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Active", "Inactive");
        Button addMemberButton = new Button("Add Member");
        addMemberButton.getStyleClass().add("Action-Button");
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("Action-Button");
        addMemberButton.setOnAction(e -> {
            String memberId = memberIdTextField.getText();
            String name = nameTextField.getText();
            String membershipType = membershipTypeComboBox.getValue();
            String email = emailTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String status = statusComboBox.getValue();


            // Validate if the user has entered an empty field
            if (memberId.isEmpty() || name.isEmpty() || membershipType.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || status.isEmpty()) {
                AlertBox.display("Invalid Member", "Please enter a valid member data");
                stage.close();
                AddMember.add();
                return;
            }

            //Validate if the user has entered a valid email format
            if (!Validations.validateEmail(email)) {
                AlertBox.display("Invalid Data", "Please enter a valid email format");
                stage.close();
                AddMember.add();
                return;
            }

            // Validate Phone Number Format
            if (!Validations.validatePhoneNumber(phoneNumber)) {
                AlertBox.display("Wrong Format", "Phone Number Format is wrong, please try again");
                stage.close();
                AddMember.add();
                return;
            }

            // Validate Member ID
            if (!Validations.validateMemberId(memberId)) {
                AlertBox.display("Invalid Member", "Please enter a valid member ID");
                stage.close();
                AddMember.add();
                return;
            }

            boolean confirmation = Backend.addMember(memberId, name, membershipType, email, phoneNumber, status);
            // Validate if Member Already Exists
            if (!confirmation) {
                AlertBox.display("Invalid Member Error", "Member Already exists, please try again");
                stage.close();
                AddMember.add();
                return;
            }

            //If all is good
            MessageBox.display("Message", "Member with ID " + memberId + " added successfully");
            stage.close();
            TrainerMenu.menu();
        });
        backButton.setOnAction(e -> {
            stage.close();
            TrainerMenu.menu();
            return;
        });

        GridPane grid = new GridPane();
        grid.add(memberIdLabel,0,0);
        grid.add(memberIdTextField,1,0);
        grid.add(nameLabel,0,1);
        grid.add(nameTextField,1,1);
        grid.add(membershipTypeLabel,0,2);
        grid.add(membershipTypeComboBox,1,2);
        grid.add(emailLabel,0,3);
        grid.add(emailTextField,1,3);
        grid.add(phoneNumberLabel,0,4);
        grid.add(phoneNumberTextField,1,4);
        grid.add(statusLabel,0,5);
        grid.add(statusComboBox,1,5);
        grid.add(backButton,0,6);
        grid.add(addMemberButton,1,6);
        //createGridPane grid = new createGridPane(memberIdLabel, memberIdTextField, nameLabel, nameTextField, membershipTypeLabel, membershipTypeComboBox, phoneNumberLabel, phoneNumberTextField, emailLabel, emailTextField, statusLabel, statusComboBox, addMemberButton);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
}
