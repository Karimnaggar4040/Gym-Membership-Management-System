package Frontend;

import Backend.Backend;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class RemoveTrainer {
    public static void remove() {
        Stage stage = new Stage();
        stage.setTitle("Remove Trainer");
        stage.setResizable(false);

        Label trainerIdLabel = new Label("Trainer ID");
        TextField trainerIdTextField = new TextField();

        Button backButton = new Button("Back");
        backButton.getStyleClass().add("Action-Button");
        backButton.setOnAction(e -> {
            stage.close();
            AdminMenu.adminMenu();
        });

        Button removeButton = new Button("Remove");
        removeButton.getStyleClass().add("Action-Button");
        removeButton.setOnAction(e -> {
            String trainerId = trainerIdTextField.getText();

            // Validate if the user has entered an empty field
            if (trainerId.isEmpty()) {
                AlertBox.display("Invalid Trainer", "Please enter a valid trainer data");
            }

            boolean confirmation = Backend.removeTrainer(trainerId);
            // Validate if trainer Already Exists
            if (!confirmation) {
                AlertBox.display("Invalid Trainer Error", "Trainer doesn't exists, please try again");
                return;
            }

            //If all is good
            MessageBox.display("Message", "Trainer with ID " + trainerId + " deleted successfully");
            stage.close();
            AdminMenu.adminMenu();
        });

        GridPane grid = new GridPane();
        grid.add(trainerIdLabel,0,0);
        grid.add(trainerIdTextField,1,0);
        grid.add(backButton,0,1);
        grid.add(removeButton,1,1);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(AddTrainer.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
}
