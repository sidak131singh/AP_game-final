package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        public void start(Stage stage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 320, 240);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());
            LoginScreen lg = new LoginScreen();
            MainScreen m = fxmlLoader.getController();
            stage.getScene().setOnKeyPressed((m::onKeyPressed));
            stage.getScene().setOnKeyReleased((m::onKeyReleased));
            stage = lg.display();

//
//
//            Stage loginStage = lg.display();
//          loginStage.show();

            // Show the MainScreen stage
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }

        public void showMainScreen() {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Parent root = fxmlLoader.load();
                Scene mainScreenScene = new Scene(root, 320, 240);
                Stage mainScreenStage = new Stage();
                mainScreenStage.setScene(mainScreenScene);
                mainScreenStage.setTitle("Main Screen");

                MainScreen m = fxmlLoader.getController();
                mainScreenScene.setOnKeyPressed((m::onKeyPressed));
                mainScreenScene.setOnKeyReleased((m::onKeyReleased));

                mainScreenStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        }



