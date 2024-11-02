package Frontend;

import Backend.Backend;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Frontend extends Application {

    public static void main(String[] args) {
        Backend.main();
        launch(args);
    }

    @Override
    public void start(Stage IntroductionStage) throws Exception {
        IntroductionStage.setTitle("Gym Membership Management System");
        IntroductionStage.show();
        IntroductionStage.setResizable(false);

        Button adminRoleButton = new Button("Admin Role");
        adminRoleButton.setOnAction(e -> {

        });
        Button trainerRoleButton = new Button("Trainer Role");
        trainerRoleButton.setOnAction(e -> {
            IntroductionStage.close();
            TrainerRole_gui.trainerRole();
        });


        VBox layout = new VBox();
        layout.getChildren().addAll(adminRoleButton,trainerRoleButton);
        Scene scene = new Scene(layout,300,250);
        IntroductionStage.setScene(scene);

    }

}