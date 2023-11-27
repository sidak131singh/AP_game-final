package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Hero extends coordinates {

    @FXML
    private Rectangle pillar;
    @FXML
    private ImageView hero;

    public Hero(ImageView hero) {
        this.hero = hero;
    }

    private double speed = 45.0;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    private int x_coord;
    private int y_coord;
    private cherry cherries;

    public void Move(double stickLength, ImageView hero) {
        // Create a TranslateTransition to move the hero
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(hero);

        // Calculate the duration based on the stick length and hero speed
        double durationSeconds = stickLength / speed;
        transition.setDuration(Duration.seconds(durationSeconds));

        // Move the hero to the right (adjust direction as needed)
        transition.setToX(hero.getTranslateX() + stickLength + 20);

        // Play the transition
        transition.play();
    }


    public int getX_coord() {
        return x_coord;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public void setY_coord(int y_coord) {
        this.y_coord = y_coord;
    }

    public cherry getCherries() {
        return cherries;
    }

    public void setCherries(cherry cherries) {
        this.cherries = cherries;
    }


    private boolean isFlipped = false;

    public void flip(ImageView hero) {
        double centerY = hero.getLayoutY() + hero.getBoundsInLocal().getHeight() / 2;
        if (!isFlipped) {
            hero.setScaleY(-1); // Flip vertically
            hero.setLayoutY(centerY - (hero.getBoundsInLocal().getHeight() / 2));
        } else {
            hero.setScaleY(1); // Revert to normal
            hero.setLayoutY(centerY + (hero.getBoundsInLocal().getHeight() / 2));
        }
        isFlipped = !isFlipped;
    }

    public void startFalling(ImageView hero) {
        double fallDistance = 500.0; // Adjust the fall distance as needed
        double fallDurationSeconds = 2.0; // Adjust the fall duration as needed

        // Calculate the absolute Y position to move the hero to
        double finalY = hero.getY() + fallDistance;

        // Create a TranslateTransition to move the hero down
        TranslateTransition fallTransition = new TranslateTransition();
        fallTransition.setNode(hero);
        fallTransition.setToY(finalY);  // Use setToY to move to an absolute position
        fallTransition.setDuration(Duration.seconds(fallDurationSeconds));

        // Play the transition
        fallTransition.play();
    }


//    public void checkAndHandleHeroFall(ImageView hero, Rectangle pole) {
//        // Assuming hero and pole have appropriate getX() methods or similar to get their X positions
//        double heroX = hero.getX();
//        double poleX = pole.getX();
//
//        // Adjust the threshold as needed based on your game's logic
//        double threshold = 10.0; // Example threshold, adjust as per your game
//
//        // Check if the hero is within a certain distance (threshold) of the pole
//        if (Math.abs(heroX - poleX) > threshold) {
//            // Hero is not close enough to the pole, so initiate the falling action
//            startFalling(hero);  // Adjust the method name based on your implementation
//        }


    }
