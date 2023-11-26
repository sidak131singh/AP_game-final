package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends coordinates{
    @FXML
    private ImageView hero;

    public Hero(ImageView hero) {
        this.hero = hero;
    }

    private double speed=20.0;
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
        transition.setToX(hero.getTranslateX() + stickLength +20);

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

    public void flip(){

     }





}
