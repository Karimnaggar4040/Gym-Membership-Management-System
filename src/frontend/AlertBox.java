package frontend;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AlertBox { // The method still needs having some styles added.
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL); // To make the user can only interact with this alert window first and when it is closed he can interact with the other window displayed.

        Label errorLabel = new Label();
        errorLabel.setText(message);
        Path errorImagePath = Paths.get("crc_error.png");
        Image errorImage = new Image("file:"+errorImagePath);
        ImageView errorImageView = new ImageView(errorImage);
        errorImageView.setFitHeight(50);
        errorImageView.setFitWidth(50);
        HBox layout = new HBox(); // Change or customize the type of this layout.
        layout.getChildren().add(errorImageView);
        layout.getChildren().add(errorLabel);
        layout.setAlignment(Pos.BOTTOM_CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(50,50, 50, 50));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
