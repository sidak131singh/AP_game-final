package com.example.stickhero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverScreenTest {


    @Test
    public void testGetGmCherry() {
       // MainScreen m = new MainScreen();

 GameOverScreen g = new GameOverScreen();


    g.gmcherrycount = 3;


        String result = g.getgmcherry();


        assertEquals(2, g.gmcherrycount);

        assertEquals("2", result);
    }
}