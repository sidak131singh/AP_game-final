
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
@FXML
        private Rectangle pillar;
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
        else if(event.getCode()==KeyCode.F){
            System.out.println("flip");
            herox.flip(hero);
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


            double heroX = hero.getLayoutX() + stick.getHeight();
            double poleX = pillar.getLayoutX();
            System.out.println(heroX);
            System.out.println(poleX);
            System.out.println(Math.abs(heroX - poleX));

            // Adjust the threshold as needed based on your game's logic
            double threshold = 68.0; // Example threshold, adjust as per your game
            double time = stick.getHeight()/herox.getSpeed();
            // Check if the hero is within a certain distance (threshold) of the pole
            if (Math.abs(heroX - poleX)>= threshold ) {
                System.out.println("hiiii");

                // Create a Timeline to delay the startFalling call
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time), evt -> {
                    // Initiate the falling action after a delay (adjust the duration as needed)
                    herox.startFalling(hero); // Adjust the method name based on your implementation
                }));

                timeline.play();
            }

        }
    }


// hello
    


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
