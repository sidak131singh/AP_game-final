package com.example.stickhero;

public class Stick extends coordinates {
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
    public void fall(){}
    public boolean iscorrect(){

        return true;
    }



}

