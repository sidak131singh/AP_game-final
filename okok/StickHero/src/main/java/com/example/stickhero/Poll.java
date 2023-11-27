package com.example.stickhero;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class Poll {
@FXML
private Rectangle pillar;

    public Poll(Rectangle pillar) {
        this.pillar = pillar;
    }

    private int width;
    private int distance;
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void randomgenerate(){}

}
