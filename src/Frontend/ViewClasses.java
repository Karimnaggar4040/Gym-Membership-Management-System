package Frontend;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewClasses {
    protected static void view() {
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.setTitle("Classes");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 300, 300);
        TableView<ClassGui> classGuiTableView = new TableView<>();
        classGuiTableView.setItems(TrainerRoleLogin.getClasses());
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
    }
}
