package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setMaximized(true);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

            LoginScreen loginController = fxmlLoader.getController();

            Button switchButton = (Button) root.lookup("#button");
            switchButton.setOnAction(event -> {
                stage.hide(); // Hide the login stage
                showMainScreen(scene); // Pass the scene to the method
            });

            stage.show(); // Show the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMainScreen(Scene previousScene) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene mainScreenScene = new Scene(root);


            // Retrieve the controller for the MainScreens
            MainScreen mainScreenController = fxmlLoader.getController();

            // Set the event handler for scene click
            mainScreenScene.setOnMouseClicked(event -> mainScreenController.startGrowing());

            // Set the scene for the mainScreenStage
            Stage mainScreenStage = new Stage();
            mainScreenStage.setScene(mainScreenScene);
            mainScreenStage.setTitle("Main Screen");

            // Close the previous scene (login screen)
            Stage loginStage = (Stage) previousScene.getWindow();
            loginStage.close();

            mainScreenStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}