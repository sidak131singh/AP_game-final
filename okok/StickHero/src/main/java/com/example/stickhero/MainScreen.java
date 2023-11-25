package com.example.stickhero;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainScreen implements Screen {
    @FXML
    private Rectangle stickRect;

    private double initialHeight;
    private double startHeight;
    private boolean isGrowing = false;

    @FXML
    public void initialize() {
        initialHeight = stickRect.getHeight();
        startHeight = stickRect.getHeight();
    }


    @FXML
    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.U && !isGrowing) {
            isGrowing = true;
            startGrowing(); // Start the growth animation only if it's not already growing
        }
    }


    @FXML
    public void onKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.U) {
            isGrowing = false;
        }
    }

    private void startGrowing() {
        AnimationTimer timer = new AnimationTimer() {
            double height = stickRect.getHeight();
            long lastUpdateTime = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdateTime >= 30_000_000) { // Adjust the duration (in nanoseconds) for smoother growth
                    height += 5; // Increment the height
                    stickRect.setY(20 - (height - initialHeight)); // Adjust Y-coordinate based on new height
                    //stickRect.setY(20);
                    stickRect.setHeight(height); // Set the updated height
                    lastUpdateTime = now;
                }
                if (height >= 10 || !isGrowing) { // Stop growing when reaching max height or released key
                    stop();
                }
            }
        };
        timer.start();
    }


    @FXML
            public Stage display() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage.setTitle("Welcome to stick hero");



        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

       stage.setFullScreen(true);
        stage.setScene(scene);
        return stage;
    }






}