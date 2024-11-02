package Frontend;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewTrainers {
    protected static void view() {
        Stage stage = new Stage();
        stage.setTitle("View member");
        stage.setResizable(true);
        VBox vbox = new VBox();
        TableView<MemberGui> tableView = new TableView<>();
        vbox.getChildren().add(tableView);
        tableView.setItems(TrainerRoleLogin.getMembers());
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
}
