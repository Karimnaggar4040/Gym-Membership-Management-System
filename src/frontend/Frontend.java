package frontend;

import backend.Backend;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

        // position the window
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        double xPosition = screenWidth * 0.35;
        double yPosition = screenHeight * 0.25;
        IntroductionStage.setX(xPosition);
        IntroductionStage.setY(yPosition);
        IntroductionStage.setWidth(500);
        IntroductionStage.setHeight(400);

        Image logo = new Image("file:gym.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(50);
        logoView.setFitWidth(50);
        VBox logoLayout = new VBox();
        logoLayout.setAlignment(Pos.CENTER);
        logoLayout.setPadding(new Insets(20,10,10,10));


        logoLayout.getChildren().add(logoView);
        Label gymTitle = new Label("Gym El BULDOZER ");
        gymTitle.getStyleClass().add("gym-title");

        logoLayout.getChildren().add(gymTitle);


        Button adminRoleButton = new Button("Admin Role");
        adminRoleButton.getStyleClass().add("main-button");
        adminRoleButton.setOnAction(e -> {
            IntroductionStage.close();
            AdminRoleLogin.adminRoleLogin();
        });
        Button trainerRoleButton = new Button("Trainer Role");
        trainerRoleButton.getStyleClass().add("main-button");
        trainerRoleButton.setOnAction(e -> {
            IntroductionStage.close();
            TrainerRoleLogin.trainerRole();
        });


        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        grid.add(adminRoleButton, 0, 0);
        grid.add(trainerRoleButton, 0, 1);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(logoLayout);
        mainLayout.setCenter(grid);
        Scene scene = new Scene(mainLayout, 300, 200);

        scene.getStylesheets().add(Objects.requireNonNull(TrainerRoleLogin.class.getResource("Styles.css")).toExternalForm());
        IntroductionStage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double centerX = (screenBounds.getWidth() - IntroductionStage.getWidth()) / 2;
        double centerY = (screenBounds.getHeight() - IntroductionStage.getHeight()) / 2;


        IntroductionStage.show();
    }

}