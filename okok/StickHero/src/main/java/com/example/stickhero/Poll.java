package com.example.stickhero;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class Poll  {
    @FXML
    private Rectangle poll;
    // other fields and methods...

    public Poll(Rectangle pole) {
        poll = pole;
    }
    private double x= poll.getX();
    private double y;



    public double getX() {
        return poll.getX();
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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
