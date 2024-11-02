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

public class TrainerRole_gui {
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

        GridPane grid = createGridPane();
        grid.add(userLabel, 0, 0);
        grid.add(userName, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(password, 1, 1);
        grid.add(loginButton, 1, 2);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

        loginButton.setOnAction(e -> {
            String inputUsername = userName.getText();
            String inputPassword = password.getText();
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
            } else if (inputUsername.equals(LoginCredentials.TRAINER_USERNAME) && inputPassword.equals(LoginCredentials.TRAINER_PASSWORD)) {
                stage.close();
                trainerMenu();
            } else
                AlertBox.display("Invalid Credentials", "Please enter a valid username/password");
        });
    }

    public static void trainerMenu() {
        Stage stage = new Stage();
        stage.setTitle("Trainer Role");
        stage.setResizable(false);

        Button addMemberButton = new Button("Add Member");
        addMemberButton.setOnAction(e -> {
            addMember();
            stage.close();
        });
        addMemberButton.getStyleClass().add("Menu-Button");

        Button viewMemberButton = new Button("View Members");
        viewMemberButton.getStyleClass().add("Menu-Button");
        viewMemberButton.setOnAction(e -> viewMembers());

        Button addClassButton = new Button("Add Class");
        addClassButton.setOnAction(e -> {
            addClass();
        });
        addClassButton.getStyleClass().add("Menu-Button");

        Button viewClassButton = new Button("View Classes");
        viewClassButton.setOnAction(e -> viewClasses());
        viewClassButton.getStyleClass().add("Menu-Button");

        Button registerButton = new Button("Register Member");
        registerButton.setOnAction(e -> {
            addMemberRegistration();
            stage.close();
        });
        registerButton.getStyleClass().add("Menu-Button");

        Button cancelButton = new Button("Cancel Registration");
        cancelButton.getStyleClass().add("Menu-Button");

        Button viewButton = new Button("View Registrations");
        viewButton.setOnAction(e -> viewRegistrations());
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
        layout.getChildren().addAll(addMemberButton, viewMemberButton, addClassButton, viewClassButton, registerButton, cancelButton, viewButton);

        Scene scene = new Scene(layout, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private static void addMember() {
        Stage stage = new Stage();
        stage.setTitle("Add Member");
        stage.setResizable(false);

        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTextField = new TextField();
        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();
        Label membershipTypeLabel = new Label("Membership Type");
        ComboBox<String> membershipTypeComboBox = new ComboBox<>();
        membershipTypeComboBox.getItems().addAll("Weekly","Monthly","Yearly");
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        Label phoneNumberLabel = new Label("Phone Number");
        TextField phoneNumberTextField = new TextField();
        Label statusLabel = new Label("Status");
        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Active", "Inactive");
        Button addMemberButton = new Button("Add Member");
        addMemberButton.getStyleClass().add("Action-Button");
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
                addMember();
                return;
            }

            //Validate if the user has entered a valid email format
            if (!validateEmail(email)) {
                AlertBox.display("Invalid Data", "Please enter a valid email format");
                stage.close();
                addMember();
                return;
            }

            // Validate Phone Number Format
            if (!validatePhoneNumber(phoneNumber)) {
                AlertBox.display("Wrong Format", "Phone Number Format is wrong, please try again");
                stage.close();
                addMember();
                return;
            }

            // Validate Member ID
            if (!validateMemberId(memberId)){
                AlertBox.display("Invalid Member", "Please enter a valid member ID");
                stage.close();
                addMember();
                return;
            }

            boolean confirmation = Backend.addMember(memberId, name, membershipType, email, phoneNumber, status);
            // Validate if Member Already Exists
            if (!confirmation) {
                AlertBox.display("Invalid Member Error", "Member Already exists, please try again");
                stage.close();
                addMember();
                return;
            }

            //If all is good
            MessageBox.display("Message", "Member with ID " + memberId + " added successfully");
            stage.close();
            trainerMenu();
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
        grid.add(addMemberButton,1,6);
        //createGridPane grid = new createGridPane(memberIdLabel, memberIdTextField, nameLabel, nameTextField, membershipTypeLabel, membershipTypeComboBox, phoneNumberLabel, phoneNumberTextField, emailLabel, emailTextField, statusLabel, statusComboBox, addMemberButton);
        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private static void addMemberRegistration() {
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
        Button addClassButton = new Button("Register");
        addClassButton.getStyleClass().add("Action-Button");
        addClassButton.setOnAction(e -> {
            String memberId = memberIdTextField.getText();
            String classId = classIdTextField.getText();
            LocalDate registrationDate = registrationDatePicker.getValue();

            // Validate Member ID
            if (!validateMemberId(memberId)) {
                AlertBox.display("Invalid Member", "Please enter a valid member ID");
                stage.close();
                addMemberRegistration();
                return;
            }

            // Validate that the member exists
            if (Backend.searchForMember(memberId) == null){
                AlertBox.display("Invalid Member", "Member does not exist, please try again");
                stage.close();
                addMemberRegistration();
                return;
            }

            // Validate Class ID
            if (!validateClassId(classId)) {
                AlertBox.display("Invalid Class", "Please enter a valid class ID");
                stage.close();
                addMemberRegistration();
                return;
            }

            // Validate that the class exists
            if (Backend.searchForClass(classId) == null){
                AlertBox.display("Invalid Class", "Class does not exist, please try again");
                stage.close();
                addMemberRegistration();
                return;
            }

            boolean confirmation = Backend.addMemberRegistration(memberId, classId, registrationDate);
            if (!confirmation){
                AlertBox.display("Registration Error","This registration already exists, please try again");
                stage.close();
                addMemberRegistration();
                return;
            }

            // If added successfully
            MessageBox.display("Registration Successful","Member with ID " + memberId + " registered successfully to class " + classId);
            stage.close();
            trainerMenu();
        });

//        GridPane grid = createGridPane();
//        grid.add(memberIdLabel,0,0);
//        grid.add(memberIdTextField,1,0);
//        grid.add(classIdLabel,0,1);
//        grid.add(classIdTextField,1,1);
//        grid.add(registrationDateLabel,0,2);
//        grid.add(registrationDatePicker,1,2);
//        grid.add(addClassButton,1,3);
        createGridPane grid = new createGridPane(memberIdLabel, memberIdTextField, classIdLabel, classIdTextField, registrationDateLabel, registrationDatePicker, addClassButton);
        Scene scene = new Scene(grid.getGridPane(), 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    } // DONE

    private static void addClass() {
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
        SpinnerValueFactory<Integer> durationValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(30,120,30,5);
        durationSpinner.setValueFactory(durationValueFactory);
        durationSpinner.setEditable(true);
        Label availableSeatsLabel = new Label("Available Seats");
        Spinner<Integer> availableSeatsSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> availableSeatsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,60,5,1);
        availableSeatsSpinner.setValueFactory(availableSeatsValueFactory);
        availableSeatsSpinner.setEditable(true);

        Button addClassButton = new Button("Add Class");
        addClassButton.getStyleClass().add("Action-Button");
        addClassButton.setOnAction(e -> {
            // Validate no empty fields
            if (classNameTextField.getText().isEmpty() || classIdTextField.getText().isEmpty()) {
                AlertBox.display("Invalid Class", "Please enter a valid class data");
                addClass();
            }

            String classId = classIdTextField.getText();
            String className = classNameTextField.getText();
            String trainerId = trainerIdTextField.getText();
            int duration = durationSpinner.getValue();
            int availableSeats = availableSeatsSpinner.getValue();

            // Validate Class ID
            if (!validateClassId(classId)) {
                AlertBox.display("Invalid Class", "Please enter a valid class ID Format");
                stage.close();
                addClass();
                return;
            }
            boolean confirmation = Backend.addNewClasses(classId, className, trainerId, duration, availableSeats);
            if (!confirmation) {
                AlertBox.display("Invalid Class ", "Class Already Exists, please try again");
                addClass();
            }
        });

        GridPane grid = createGridPane();
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

        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add(Objects.requireNonNull(TrainerRole_gui.class.getResource("Styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    } // DONE

    private static void viewRegistrations() {
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.setTitle("View Registrations");

        VBox vbox = new VBox();
        TableView<MemberRegistrationGui> tableView = new TableView<>();
        tableView.setItems(getMemberRegistrations());
        vbox.getChildren().addAll(tableView);
        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();

        TableColumn<MemberRegistrationGui, String> memberIdColumn = new TableColumn<>("Member ID");
        memberIdColumn.setMinWidth(75);
        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        tableView.getColumns().add(memberIdColumn);

        TableColumn<MemberRegistrationGui, String> classIdColumn = new TableColumn<>("Class ID");
        classIdColumn.setMinWidth(75);
        classIdColumn.setCellValueFactory(new PropertyValueFactory<>("classId"));
        tableView.getColumns().add(classIdColumn);

        TableColumn<MemberRegistrationGui, String> status = new TableColumn<>("Status");
        status.setMinWidth(90);
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableView.getColumns().add(status);

        TableColumn<MemberRegistrationGui, LocalDate> registrationDateColumn = new TableColumn<>("Registration Date");
        registrationDateColumn.setMinWidth(75);
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        tableView.getColumns().add(registrationDateColumn);

    } // DONE

    private static void viewMembers() {
        Stage stage = new Stage();
        stage.setTitle("View member");
        stage.setResizable(true);
        VBox vbox = new VBox();
        TableView<MemberGui> tableView = new TableView<>();
        vbox.getChildren().add(tableView);
        tableView.setItems(getMembers());
        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();

        TableColumn<MemberGui, String> memberIdColumn = new TableColumn<>("Member ID");
        memberIdColumn.setMinWidth(75);
        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        tableView.getColumns().add(memberIdColumn);

        TableColumn<MemberGui, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(75);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().add(nameColumn);

        TableColumn<MemberGui, String> memberShipTypeColumn = new TableColumn<>("Membership Type");
        memberShipTypeColumn.setMinWidth(100);
        memberShipTypeColumn.setCellValueFactory(new PropertyValueFactory<>("memberShipType"));
        tableView.getColumns().add(memberShipTypeColumn);

        TableColumn<MemberGui, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.getColumns().add(emailColumn);

        TableColumn<MemberGui, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setMinWidth(100);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableView.getColumns().add(phoneNumberColumn);

        TableColumn<MemberGui,String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(90);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableView.getColumns().add(statusColumn);

    } // TODO: status needs to be handled

    private static void viewClasses() {
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.setTitle("Classes");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 300, 300);
        TableView<ClassGui> classGuiTableView = new TableView<>();
        classGuiTableView.setItems(getClasses());
        vbox.getChildren().add(classGuiTableView);
        stage.setScene(scene);
        stage.show();

        TableColumn<ClassGui, String> classIdColumn = new TableColumn<>("Class ID");
        classIdColumn.setMinWidth(75);
        classIdColumn.setCellValueFactory(new PropertyValueFactory<>("classId"));
        classGuiTableView.getColumns().add(classIdColumn);

        TableColumn<ClassGui, String> classNameColumn = new TableColumn<>("Class Name");
        classNameColumn.setMinWidth(100);
        classNameColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        classGuiTableView.getColumns().add(classNameColumn);

        TableColumn<ClassGui, String> trainerIdColumn = new TableColumn<>("Trainer ID");
        trainerIdColumn.setMinWidth(75);
        trainerIdColumn.setCellValueFactory(new PropertyValueFactory<>("trainerId"));
        classGuiTableView.getColumns().add(trainerIdColumn);

        TableColumn<ClassGui, Integer> durationColumn = new TableColumn<>("Duration");
        durationColumn.setMinWidth(50);
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        classGuiTableView.getColumns().add(durationColumn);

        TableColumn<ClassGui, Integer> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setMinWidth(50);
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));
        classGuiTableView.getColumns().add(availableSeatsColumn);
    } // DONE

    private static GridPane createGridPane() {
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