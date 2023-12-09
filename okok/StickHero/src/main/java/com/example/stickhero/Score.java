package com.example.stickhero;

public class Score {
    private int count;

    public Score(int count) {
        this.count = count;
    }

    public void setScore(int s){
        s= count;
    }
    public int getScore(){
        return count;
    }
    public void updateScore(){
        count++;
    }



}
