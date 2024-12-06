package com.example.bballengine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Scene scene1,scene2;
    public static Stage stage;
    public static DetailsController detailsController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BBallapp.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Deatails.fxml"));
        scene1 = new Scene(loader1.load());
        scene2 = new Scene(loader2.load());
        detailsController = loader2.getController();
        stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("image/NBAlog.png")));
        stage.setTitle("Basketball Player Search");
        stage.setScene(scene1);
        stage.show();
        Main.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}

