package Frontend;

import Backend.Backend;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Objects;

public class Frontend extends Application {

    public static void main(String[] args) {
        Backend.main();
        launch(args);
    }

    @Override
    public void start(Stage IntroductionStage) throws Exception {
        IntroductionStage.setTitle("Gym Membership Management System");


        Button adminRoleButton = new Button("Admin Role");
        adminRoleButton.setOnAction(e -> {

        });
        Button trainerRoleButton = new Button("Trainer Role");
        trainerRoleButton.setOnAction(e -> {
            IntroductionStage.close();
            TrainerRoleLogin.trainerRole();
        });


        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.add(adminRoleButton, 0, 0);
        grid.add(trainerRoleButton, 0, 1);
        Scene scene = new Scene(grid,300,100);

        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        IntroductionStage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double centerX = (screenBounds.getWidth() - IntroductionStage.getWidth()) / 2;
        double centerY = (screenBounds.getHeight() - IntroductionStage.getHeight()) / 2;

        // Set the stage position to the center
        IntroductionStage.setX(centerX);
        IntroductionStage.setY(centerY);
        IntroductionStage.setResizable(false);
        IntroductionStage.show();
    }

}