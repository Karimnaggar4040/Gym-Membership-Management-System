package Frontend;
import Backend.Backend;
import Constants.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
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

        GridPane grid = createGridPane();
        grid.add(userLabel,0,0);
        grid.add(userName,1,0);
        grid.add(passwordLabel,0,1);
        grid.add(password,1,1);
        grid.add(loginButton,1,2);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
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

        Button addMemberButton = new Button("Add Member");
        addMemberButton.setOnAction(e ->{
            addMember();
            stage.close();
        });
        addMemberButton.getStyleClass().add("Menu-Button");
        Button viewMemberButton = new Button("View Member");
        viewMemberButton.getStyleClass().add("Menu-Button");
        Button addClassButton = new Button("Add Class");

        addClassButton.getStyleClass().add("Menu-Button");
        Button viewClassButton = new Button("View Class");
        viewClassButton.getStyleClass().add("Menu-Button");
        Button registerButton = new Button("Register Member");
        registerButton.setOnAction(e -> {
            addMemberRegistration();
            stage.close();
        });
        registerButton.getStyleClass().add("Menu-Button");
        Button cancelButton = new Button("Cancel Registration");
        cancelButton.getStyleClass().add("Menu-Button");
        Button viewButton = new Button("View Registration");
        viewButton.getStyleClass().add("Menu-Button");

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.getChildren().addAll(addMemberButton, viewMemberButton, addClassButton, viewClassButton, registerButton, cancelButton, viewButton);

        Scene scene = new Scene(layout,300,300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private static void addMember(){
        Stage stage = new Stage();
        stage.setTitle("Add Member");
        stage.setResizable(false);

        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTextField = new TextField();
        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();
        Label membershipTypeLabel = new Label("Membership Type");
        TextField membershipTypeTextField = new TextField();
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        Label phoneNumberLabel = new Label("Phone Number");
        TextField phoneNumberTextField = new TextField();
        Label statusLabel = new Label("Status");
        TextField statusTextField = new TextField();
        Button addMemberButton = new Button("Add Member");
        addMemberButton.getStyleClass().add("Action-Button");
        addMemberButton.setOnAction(e -> {
            if (memberIdTextField.getText().isEmpty() || membershipTypeTextField.getText().isEmpty() || phoneNumberTextField.getText().isEmpty() || statusTextField.getText().isEmpty() || emailTextField.getText().isEmpty()){}
            String memberId = memberIdTextField.getText();
            String name = nameTextField.getText();
            String membershipType = membershipTypeTextField.getText();
            String email = emailTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String status = statusTextField.getText();
            boolean confirmation = Backend.addMember(memberId,name,membershipType,email,phoneNumber,status);
            if (!confirmation){
                AlertBox.display("Invalid Member Error", "Member Already exists, please try again");
                addMember();
            }
        });

//        GridPane grid = new GridPane();
//        grid.add(memberIdLabel,0,0);
//        grid.add(memberIdTextField,1,0);
//        grid.add(nameLabel,0,1);
//        grid.add(nameTextField,1,1);
//        grid.add(membershipTypeLabel,0,2);
//        grid.add(membershipTypeTextField,1,2);
//        grid.add(emailLabel,0,3);
//        grid.add(emailTextField,1,3);
//        grid.add(phoneNumberLabel,0,4);
//        grid.add(phoneNumberTextField,1,4);
//        grid.add(statusLabel,0,5);
//        grid.add(statusTextField,1,5);
//        grid.add(addMemberButton,1,6);
         createGridPane grid = new createGridPane(memberIdLabel,memberIdTextField,nameLabel,nameTextField,membershipTypeLabel,membershipTypeTextField,phoneNumberLabel,phoneNumberTextField,emailLabel,emailTextField,statusLabel,statusTextField,addMemberButton);

        Scene scene = new Scene(grid.getGridPane(),300,300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private static void addMemberRegistration(){
        Stage stage = new Stage();
        stage.setTitle("Add Class");
        stage.setResizable(false);
        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTextField = new TextField();
        Label classIdLabel = new Label("Class ID");
        TextField classIdTextField = new TextField();
        Label registrationDateLabel = new Label("Registration Date");
        DatePicker registrationDatePicker = new DatePicker();
        registrationDatePicker.setValue(LocalDate.now());
        Button addClassButton = new Button("Add Class");
        addClassButton.getStyleClass().add("Action-Button");
        addClassButton.setOnAction(e -> {
            String memberId = memberIdTextField.getText();
            String classId = classIdTextField.getText();
            LocalDate registrationDate = registrationDatePicker.getValue();
            Backend.addMemberRegistration(memberId,classId,registrationDate);
        });

//        GridPane grid = createGridPane();
//        grid.add(memberIdLabel,0,0);
//        grid.add(memberIdTextField,1,0);
//        grid.add(classIdLabel,0,1);
//        grid.add(classIdTextField,1,1);
//        grid.add(registrationDateLabel,0,2);
//        grid.add(registrationDatePicker,1,2);
//        grid.add(addClassButton,1,3);
        createGridPane grid = new createGridPane(memberIdLabel,memberIdTextField,classIdLabel,classIdTextField,registrationDateLabel,registrationDatePicker,addClassButton);
        Scene scene = new Scene(grid.getGridPane(),300,300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }



    private static GridPane createGridPane(){
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20,20,20,20));
        return grid;
    }
}












































