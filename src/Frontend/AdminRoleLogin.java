package Frontend;

import Backend.Backend;
import Backend.Class;
import Backend.PrimaryInterface;
import Constants.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminRoleLogin {
    public static void adminRoleLogin() {
        Stage stage = new Stage();
        stage.setTitle("Admin Role");
        stage.setResizable(false);

        Label userLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        TextField userName = new TextField();
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Button loginButton = new Button("Login");
        loginButton.setId("loginButton");

        GridPane grid = createGridPane();
        grid.add(userLabel, 0, 0);
        grid.add(userName, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(password, 1, 1);
        grid.add(loginButton, 1, 2);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(AdminRoleLogin.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

        loginButton.setOnAction(e -> {
            String inputUsername = userName.getText();
            String inputPassword = password.getText();
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
            } else if (inputUsername.equals(LoginCredentials.ADMIN_USERNAME) && inputPassword.equals(LoginCredentials.ADMIN_PASSWORD)) {
                stage.close();
                AdminMenu.adminMenu();
            } else
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
        });
    }


    public static GridPane createGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));
        return grid;
    }

    private static ObservableList<MemberGui> getMembers() {
        ObservableList<MemberGui> members = FXCollections.observableArrayList();
        for (PrimaryInterface member : Backend.getListOfMembers()) {
            String memberContent = member.lineRepresentation();
            String[] memberDetails = memberContent.split(",");
            MemberGui memberGui = new MemberGui(memberDetails[0], memberDetails[1], memberDetails[2], memberDetails[3], memberDetails[4],memberDetails[5]);
            members.add(memberGui);
        }
        return members;
    } // DONE

    private static ObservableList<ClassGui> getClasses() {
        ObservableList<ClassGui> classes = FXCollections.observableArrayList();
        for (Class class_ : Backend.getListOfClasses()) {
            String classContent = class_.lineRepresentation();
            String[] classDetails = classContent.split(",");
            ClassGui classGui = new ClassGui(classDetails[0], classDetails[1], classDetails[2], Integer.parseInt(classDetails[3]), Integer.parseInt(classDetails[4]));
            classes.add(classGui);
        }
        return classes;
    } // DONE

    private static ObservableList<MemberRegistrationGui> getMemberRegistrations() {
        ObservableList<MemberRegistrationGui> memberRegistrations = FXCollections.observableArrayList();
        for (PrimaryInterface memberClassRegistration : Backend.getListOfRegistrations()) {
            String content = memberClassRegistration.lineRepresentation();
            String[] contentParts = content.split(",");
            MemberRegistrationGui memberRegistrationGui = new MemberRegistrationGui(contentParts[0], contentParts[1], LocalDate.parse(contentParts[2]), contentParts[3]);
            memberRegistrations.add(memberRegistrationGui);
        }
        return memberRegistrations;
    } // DONE

    private static boolean validateEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    } // DONE

    private static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11)
            return false;
        return phoneNumber.matches("\\d+"); // Returns true if str contains only digits

    } // DONE

    // ID Validations
    private static boolean validateMemberId(String memberId){
        char[] memberIdChars = memberId.toCharArray();
        return memberIdChars[0] == 'M';
    }
    private static boolean validateClassId(String classId){
        char[] classIdChars = classId.toCharArray();
        return classIdChars[0] == 'C';
    }
}