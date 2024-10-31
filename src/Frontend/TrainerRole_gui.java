package Frontend;
import Constants.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.Objects;

public class TrainerRole_gui {
    public static void trainerRole(){
        Stage stage = new Stage();
        stage.setTitle("Trainer Role");
        stage.setResizable(false);

        Label userLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        TextField userName = new TextField();
        PasswordField password = new PasswordField();
        Button loginButton = new Button("Login");
        loginButton.setId("loginButton");

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20,20,20,20));
        grid.add(userLabel,0,0);
        grid.add(userName,1,0);
        grid.add(passwordLabel,0,1);
        grid.add(password,1,1);
        grid.add(loginButton,1,2);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("TrainerRole_gui.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

        loginButton.setOnAction(e -> {
            String inputUsername = userName.getText();
            String inputPassword = password.getText();
            if (inputUsername.isEmpty() || inputPassword.isEmpty()){
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
            }
            else if (inputUsername.equals(LoginCredentials.TRAINER_USERNAME) && inputPassword.equals(LoginCredentials.TRAINER_PASSWORD)){
                stage.close();
                trainerMenu();
            }
            else
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
        });
    }

    public static void trainerMenu(){
        Stage stage = new Stage();
        stage.setTitle("Trainer Role");
        stage.setResizable(false);

        Button addMember = new Button("Add Member");
        addMember.getStyleClass().add("Menu-Button");
        Button viewMember = new Button("View Member");
        viewMember.getStyleClass().add("Menu-Button");
        Button addClass = new Button("Add Class");
        addClass.getStyleClass().add("Menu-Button");
        Button viewClass = new Button("View Class");
        viewClass.getStyleClass().add("Menu-Button");
        Button register = new Button("Register Member");
        register.getStyleClass().add("Menu-Button");
        Button cancel = new Button("Cancel Registration");
        cancel.getStyleClass().add("Menu-Button");
        Button view = new Button("View Registration");
        view.getStyleClass().add("Menu-Button");

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.getChildren().addAll(addMember,viewMember,addClass,viewClass,register,cancel,view);

        Scene scene = new Scene(layout,300,300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("TrainerRole_gui.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
