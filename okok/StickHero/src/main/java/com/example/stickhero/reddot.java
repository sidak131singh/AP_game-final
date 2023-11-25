package com.example.stickhero;

public class reddot extends coordinates {
    private int x_coord;
    private int y_coord;
    public boolean touch(){
        return true;
    }


    @Override
    public int getX_coord() {
        return  x_coord;
    }

    @Override
    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;

    }

    @Override
    public int getY_coord() {
        return y_coord;
    }

    @Override
    public void setY_coord(int y_coord) {
        this.y_coord = y_coord;

    }
}
