package com.example.stickhero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    @Test
    void testUpdateScore() {
        int i =0;

       Score Object = new Score(i);

       Object.setScore(0);


    Object.updateScore();


        assertEquals(1, Object.getScore(), "Score should be incremented by 1");
    }
}