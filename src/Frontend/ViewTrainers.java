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

public class ViewTrainers {
    protected static void view() {
        Stage stage = new Stage();
        stage.setTitle("View Trainers");
        stage.setResizable(true);
        stage.setWidth(700);
        stage.setHeight(400);

        VBox vbox = new VBox();
        TableView<TrainerGui> tableView = new TableView<>();
        vbox.getChildren().add(tableView);
        tableView.setItems(getTrainers());
        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();

        TableColumn<TrainerGui, String> trainerIdColumn = new TableColumn<>("Trainer ID");
        trainerIdColumn.setMinWidth(75);
        trainerIdColumn.setCellValueFactory(new PropertyValueFactory<>("trainerID"));
        tableView.getColumns().add(trainerIdColumn);

        TableColumn<TrainerGui, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(75);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().add(nameColumn);

        TableColumn<TrainerGui, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.getColumns().add(emailColumn);

        TableColumn<TrainerGui, String> specialityColumn = new TableColumn<>("Speciality");
        specialityColumn.setMinWidth(100);
        specialityColumn.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        tableView.getColumns().add(specialityColumn);

        TableColumn<TrainerGui, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setMinWidth(100);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableView.getColumns().add(phoneNumberColumn);

    }

    private static ObservableList<TrainerGui> getTrainers() {
        ObservableList<TrainerGui> trainers = FXCollections.observableArrayList();
        for (PrimaryInterface trainer : Backend.getListOfMembers()) {
            String trainerContent = trainer.lineRepresentation();
            String[] trainerDetails = trainerContent.split(",");
            TrainerGui trainerGui = new TrainerGui(trainerDetails[0], trainerDetails[1], trainerDetails[2], trainerDetails[3], trainerDetails[4]);
            trainers.add(trainerGui);
        }
        return trainers;
    } // DONE
}
