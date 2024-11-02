package Frontend;

import Backend.Backend;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;
public class AdminMenu {
    public static void adminMenu() {
        Stage stage = new Stage();
        stage.setTitle("Admin Role");
        stage.setResizable(false);

        Button addTrainerButton = new Button("Add Trainer");
        addTrainerButton.setOnAction(e -> {
            AddTrainer.add();
            stage.close();
        });
        addTrainerButton.getStyleClass().add("Menu-Button");

        Button removeTrainerButton = new Button("Remove Trainer");
        removeTrainerButton.setOnAction(e -> {
            RemoveTrainer.remove();
            stage.close();
        });
        removeTrainerButton.getStyleClass().add("Menu-Button");

        Button viewTrainerButton = new Button("View Trainers");
        viewTrainerButton.setOnAction(e -> {
            ViewTrainers.view();
            stage.close();
        });
        viewTrainerButton.getStyleClass().add("Menu-Button");

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            Backend.adminLogout();
            stage.close();
        });
        logoutButton.getStyleClass().add("Menu-Button");

        VBox layout = new VBox();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.getChildren().addAll(addTrainerButton, removeTrainerButton, viewTrainerButton, logoutButton);

        Scene scene = new Scene(layout, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(AdminMenu.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}