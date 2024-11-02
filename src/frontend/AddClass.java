package frontend;

import backend.Backend;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class AddClass {
    protected static void add() {
        Stage stage = new Stage();
        stage.setTitle("Add Class");
        stage.setResizable(false);

        Label classIdLabel = new Label("Class ID");
        TextField classIdTextField = new TextField();
        Label classNameLabel = new Label("Class Name");
        TextField classNameTextField = new TextField();
        Label trainerIdLabel = new Label("Trainer ID");
        TextField trainerIdTextField = new TextField();
        Label durationLabel = new Label("Duration");
        Spinner<Integer> durationSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> durationValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(30, 120, 30, 5);
        durationSpinner.setValueFactory(durationValueFactory);
        durationSpinner.setEditable(true);
        Label availableSeatsLabel = new Label("Available Seats");
        Spinner<Integer> availableSeatsSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> availableSeatsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 60, 5, 1);
        availableSeatsSpinner.setValueFactory(availableSeatsValueFactory);
        availableSeatsSpinner.setEditable(true);

        Button addClassButton = new Button("Add Class");
        addClassButton.getStyleClass().add("Action-Button");
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("Action-Button");
        addClassButton.setOnAction(e -> {
            // Validate no empty fields
            if (classNameTextField.getText().isEmpty() || classIdTextField.getText().isEmpty()) {
                AlertBox.display("Invalid Class", "Please enter a valid class data");
                return;
            }

            String classId = classIdTextField.getText();
            String className = classNameTextField.getText();
            String trainerId = trainerIdTextField.getText();
            int duration = durationSpinner.getValue();
            int availableSeats = availableSeatsSpinner.getValue();

            // Validate that the trainer exists
            if (Backend.searchForTrainer(trainerId) == null) {
                AlertBox.display("Invalid Trainer", "Trainer does not exist, please try again");
                return;
            }
            // Validate Class ID
            if (!Validations.validateClassId(classId)) {
                AlertBox.display("Invalid Class", "Please enter a valid class ID Format");
                return;
            }
            boolean confirmation = Backend.addNewClasses(classId, className, trainerId, duration, availableSeats);
            if (!confirmation) {
                AlertBox.display("Invalid Class ", "Class Already Exists, please try again");
                AddClass.add();
                return;
            }
            MessageBox.display("Class Added Successfully", "Class added successfully");
            stage.close();
            TrainerMenu.menu();
        });
        backButton.setOnAction(e -> {
            stage.close();
            TrainerMenu.menu();
        });
        GridPane grid = TrainerRoleLogin.createGridPane();
        grid.add(classIdLabel, 0, 0);
        grid.add(classIdTextField, 1, 0);
        grid.add(classNameLabel, 0, 1);
        grid.add(classNameTextField, 1, 1);
        grid.add(trainerIdLabel, 0, 2);
        grid.add(trainerIdTextField, 1, 2);
        grid.add(durationLabel, 0, 3);
        grid.add(durationSpinner,1,3);
        grid.add(availableSeatsLabel, 0, 4);
        grid.add(availableSeatsSpinner,1,4);
        grid.add(addClassButton,1,5);
        grid.add(backButton,0,5);

        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
