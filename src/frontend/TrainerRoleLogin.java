package frontend;

import backend.Backend;
import backend.Class;
import backend.PrimaryInterface;
import constants.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

public class TrainerRoleLogin {
    public static void trainerRole() {
        Stage stage = new Stage();
        stage.setTitle("Trainer Role");
        stage.setResizable(false);

        Label userLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        TextField userName = new TextField();
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Button loginButton = new Button("Login");
        loginButton.setId("loginButton");
        loginButton.getStyleClass().add("Action-Button");

        GridPane grid = createGridPane();
        grid.add(userLabel, 0, 0);
        grid.add(userName, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(password, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

        loginButton.setOnAction(e -> {
            String inputUsername = userName.getText();
            String inputPassword = password.getText();
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
                return;
            } else if (inputUsername.equals(LoginCredentials.TRAINER_USERNAME) && inputPassword.equals(LoginCredentials.TRAINER_PASSWORD)) {
                stage.close();
                TrainerMenu.menu();
            } else {
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
                TrainerMenu.menu();
            }
        });
    }

    public static GridPane createGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));
        return grid;
    }

    protected static ObservableList<MemberGui> getMembers() {
        ObservableList<MemberGui> members = FXCollections.observableArrayList();
        for (PrimaryInterface member : Backend.getListOfMembers()) {
            String memberContent = member.lineRepresentation();
            String[] memberDetails = memberContent.split(",");
            MemberGui memberGui = new MemberGui(memberDetails[0], memberDetails[1], memberDetails[2], memberDetails[3], memberDetails[4], memberDetails[5]);
            members.add(memberGui);
        }
        return members;
    } // DONE

    protected static ObservableList<ClassGui> getClasses() {
        ObservableList<ClassGui> classes = FXCollections.observableArrayList();
        for (Class class_ : Backend.getListOfClasses()) {
            String classContent = class_.lineRepresentation();
            String[] classDetails = classContent.split(",");
            ClassGui classGui = new ClassGui(classDetails[0], classDetails[1], classDetails[2], Integer.parseInt(classDetails[3]), Integer.parseInt(classDetails[4]));
            classes.add(classGui);
        }
        return classes;
    } // DONE

    protected static ObservableList<MemberRegistrationGui> getMemberRegistrations() {
        ObservableList<MemberRegistrationGui> memberRegistrations = FXCollections.observableArrayList();
        for (PrimaryInterface memberClassRegistration : Backend.getListOfRegistrations()) {
            String content = memberClassRegistration.lineRepresentation();
            String[] contentParts = content.split(",");
            MemberRegistrationGui memberRegistrationGui = new MemberRegistrationGui(contentParts[0], contentParts[1], LocalDate.parse(contentParts[2]), contentParts[3]);
            memberRegistrations.add(memberRegistrationGui);
        }
        return memberRegistrations;
    } // DONE


}