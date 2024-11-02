package Frontend;

import Backend.Backend;
import Backend.PrimaryInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;


public class ViewRegistrations {
    protected static void view() {
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.setTitle("View Registrations");
        stage.setWidth(700);
        stage.setHeight(400);

        VBox vbox = new VBox();
        TableView<MemberRegistrationGui> tableView = new TableView<>();
        tableView.setItems(getMemberRegistrations());
        vbox.getChildren().addAll(tableView);
        Scene scene = new Scene(vbox, 500, 300);
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

    }
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
}
