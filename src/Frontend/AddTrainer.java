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

public class AddTrainer {
    public static void add() {
        Stage stage = new Stage();
        stage.setTitle("Add Trainer");
        stage.setResizable(false);

        Label trainerIdLabel = new Label("Trainer ID");
        TextField trainerIdTextField = new TextField();

        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();

        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();

        Label specialityLabel = new Label("Speciality");
        TextField specialityTextField = new TextField();

        Label phoneNumberLabel = new Label("Phone Number");
        TextField phoneNumberTextField = new TextField();

        Button addButton = new Button("Add");
        addButton.getStyleClass().add("Action-Button");
        addButton.setOnAction(e -> {
            String trainerId = trainerIdTextField.getText();
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String speciality = specialityTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();

            // Validate if the user has entered an empty field
            if (trainerId.isEmpty() || name.isEmpty()  || email.isEmpty() || phoneNumber.isEmpty() || speciality.isEmpty()) {
                AlertBox.display("Invalid Trainer", "Please enter a valid trainer data");
            }

            //Validate if the user has entered a valid email format
            if (!Validations.validateEmail(email)) {
                AlertBox.display("Invalid Data", "Please enter a valid email format");
                return;
            }

            // Validate Phone Number Format
            if (!Validations.validatePhoneNumber(phoneNumber)) {
                AlertBox.display("Wrong Format", "Phone Number Format is wrong, please try again");
                return;
            }

            // Validate trainer ID
            if (!Validations.validateTrainerId(trainerId)) {
                AlertBox.display("Invalid Trainer", "Please enter a valid Trainer ID");
                return;
            }

            boolean confirmation = Backend.addTrainer(trainerId, name, email, speciality, phoneNumber);
            // Validate if trainer Already Exists
            if (!confirmation) {
                AlertBox.display("Invalid Trainer Error", "Trainer Already exists, please try again");
                return;
            }

            //If all is good
            MessageBox.display("Message", "Trainer with ID " + trainerId + " added successfully");
            stage.close();
            AdminMenu.adminMenu();
        });

        GridPane grid = new GridPane();
        grid.add(trainerIdLabel,0,0);
        grid.add(trainerIdTextField,1,0);
        grid.add(nameLabel,0,1);
        grid.add(nameTextField,1,1);
        grid.add(emailLabel,0,2);
        grid.add(emailTextField,1,2);
        grid.add(specialityLabel,0,3);
        grid.add(specialityTextField,1,3);
        grid.add(phoneNumberLabel,0,4);
        grid.add(phoneNumberTextField,1,4);
        grid.add(addButton,1,6);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(AddTrainer.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
}
