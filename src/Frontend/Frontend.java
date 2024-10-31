package Frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Frontend extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage IntroductionStage) throws Exception {
        IntroductionStage.setTitle("Gym Membership Management System");
        IntroductionStage.show();
        IntroductionStage.setResizable(false);

        Button button1 = new Button("Admin Role");
        button1.setOnAction(e -> {

        });
        Button button2 = new Button("Trainer Role");
        button2.setOnAction(e -> {
            IntroductionStage.close();
            TrainerRole_gui.trainerRole();
        });


        VBox layout = new VBox();
        layout.getChildren().addAll(button1,button2);
        Scene scene = new Scene(layout,300,250);
        IntroductionStage.setScene(scene);
    }

}