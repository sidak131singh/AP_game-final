package com.example.stickhero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YourClassTest {

    @Test
    void testUpdateCherry() {
        int i =0;

        MainScreen Object = new MainScreen();




        Object.updateCherryCount();


        assertEquals(1,Object.getCherryCount(), "Number of cherries are incremented by 1");
    }
}

