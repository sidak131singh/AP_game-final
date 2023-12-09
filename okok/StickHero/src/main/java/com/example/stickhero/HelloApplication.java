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
import javafx.scene.shape.Rectangle;
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
            // stage.setMaximized(true);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

           // LoginScreen loginController = fxmlLoader.getController();
            LoginScreen loginController = new LoginScreen();
//            loginController.Start();
            Button switchButton = (Button) root.lookup("#button");
            switchButton.setOnAction(event -> {
                stage.hide();
                showMainScreen(scene);
            });

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMainScreen(Scene previousScene) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene mainScreenScene = new Scene(root);


            // Retrieve the controller for the MainScreen
            MainScreen mainScreenController = fxmlLoader.getController();
            mainScreenController.manageCherries();
            mainScreenController.generatePillars();

            mainScreenController.stick.setTranslateX(mainScreenController.rectangles[0].getX() );
            mainScreenScene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.U) {
                    mainScreenController.onKeyPressed(event);
                }
                else if (event.getCode() == KeyCode.F) {
                    mainScreenController.onKeyPressed(event);
                }
            });

            mainScreenScene.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.U) {
                    mainScreenController.onKeyReleased(event);
                }
            });

            Stage mainScreenStage = new Stage();
            mainScreenStage.setScene(mainScreenScene);
            mainScreenStage.setTitle("Main Screen");


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





