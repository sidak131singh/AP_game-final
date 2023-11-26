
package com.example.stickhero;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class MainScreen implements Screen {
    @FXML
    private Rectangle stick;

       Stick stickx = new Stick(stick);
@FXML
private ImageView hero;
Hero herox = new Hero(hero);
    private double initialHeight;
    private boolean isGrowing = false;
    private boolean canGrowAndFall = true;
    private boolean hasRotated = false;

    @FXML
    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.U && !hasRotated && canGrowAndFall) {
            System.out.println("grow");
            stickx.startGrowing(stick);
        }
    }

    @FXML
    public void onKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.U && !hasRotated && canGrowAndFall) {
            isGrowing = false;
            stickx.startFalling(stick);
            hasRotated = true;
            canGrowAndFall = false; // Disable further growth and fall

            herox.Move(stick.getHeight(),hero);


        }
    }





    @FXML
    public Stage display() throws IOException {
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
