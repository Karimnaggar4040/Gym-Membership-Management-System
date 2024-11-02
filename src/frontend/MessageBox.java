package frontend;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;


public class MessageBox {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL); // To make the user can only interact with this alert window first and when it is closed he can interact with the other window displayed.

        Label messageLabel = new Label();
        messageLabel.setText(message);

        HBox layout = new HBox(); // Change or customize the type of this layout.
        layout.getChildren().add(messageLabel);
        layout.setAlignment(Pos.BOTTOM_CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(50,50, 50, 50));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
