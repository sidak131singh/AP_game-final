package com.example.stickhero;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Stick extends coordinates {
    public Stick(Rectangle stick) {
        this.stick = stick;
    }

    @FXML
    private Rectangle stick;
    private boolean isGrowing = false;
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    private int length;
    private int x_coord;
    private  int y_coord;
    private int difference;

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public void stop(){

    }
    public void startFalling(Rectangle stick) {

        Rotate rotate = new Rotate(0, stick.getX() + stick.getWidth(), stick.getY() + stick.getHeight());

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new javafx.animation.KeyValue(rotate.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new javafx.animation.KeyValue(rotate.angleProperty(), 90))
        );

        timeline.setOnFinished(event -> {
            System.out.println("Fall animation finished!");
            isGrowing = false;
        });

        stick.getTransforms().add(rotate);
        timeline.play();
    }

    private double initialHeight;
    void startGrowing(Rectangle stick) {
        AnimationTimer timer = new AnimationTimer() {
            double height = stick.getHeight();
            long lastUpdateTime = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdateTime >= 30_000_000) {
                    height += 5;
                    stick.setY(20 - (height - initialHeight));
                    stick.setHeight(height);
                    lastUpdateTime = now;
                }
                if (height >= 10 || !isGrowing) {
                    stop();
                }
            }
        };
        timer.start();
    }
    public boolean iscorrect(){

        return true;
    }



}

