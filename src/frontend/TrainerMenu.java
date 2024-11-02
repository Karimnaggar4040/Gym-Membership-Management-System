package frontend;

import backend.Backend;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class TrainerMenu {
    public static void menu() {
        Stage stage = new Stage();
        stage.setTitle("Trainer Role");
        stage.setResizable(false);

        Button addMemberButton = new Button("Add Member");
        addMemberButton.setOnAction(e -> {
            AddMember.add();
            stage.close();
        });
        addMemberButton.getStyleClass().add("Menu-Button");

        Button viewMemberButton = new Button("View Members");
        viewMemberButton.getStyleClass().add("Menu-Button");
        viewMemberButton.setOnAction(e -> ViewMembers.view());

        Button addClassButton = new Button("Add Class");
        addClassButton.setOnAction(e -> {
            AddClass.add();
            stage.close();
        });
        addClassButton.getStyleClass().add("Menu-Button");

        Button viewClassButton = new Button("View Classes");
        viewClassButton.setOnAction(e -> ViewClasses.view());
        viewClassButton.getStyleClass().add("Menu-Button");

        Button registerButton = new Button("Register Member");
        registerButton.setOnAction(e -> {
            AddMemberRegistration.add();
            stage.close();
        });
        registerButton.getStyleClass().add("Menu-Button");

        Button cancelButton = new Button("Cancel Registration");
        cancelButton.getStyleClass().add("Menu-Button");
        cancelButton.setOnAction(e-> {
            stage.close();
            CancelRegistration.cancel();
        });

        Button viewButton = new Button("View Registrations");
        viewButton.setOnAction(e -> ViewRegistrations.view());
        viewButton.getStyleClass().add("Menu-Button");

        Button logoutButton = new Button("Logout");
        logoutButton.getStyleClass().add("Menu-Button");
        logoutButton.setOnAction(e -> {
            Backend.trainerLogout();
            stage.close();
        });

        VBox layout = new VBox();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.getChildren().addAll(addMemberButton, viewMemberButton, addClassButton, viewClassButton, registerButton, cancelButton, viewButton,logoutButton);

        Scene scene = new Scene(layout, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
