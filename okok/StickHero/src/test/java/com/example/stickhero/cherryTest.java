package com.example.stickhero;

import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cherryTest {

    @Test
    void testHideCherry() {

        ImageView imageView = new ImageView();
        cherry c1 = new cherry(imageView);


        // When
c1.hideCherry();

        // Then
        assertFalse(imageView.isVisible(), "Cherry should be hidden");
    }

    @Test
    void testShowCherry() {
        // Given

        ImageView imageView = new ImageView();
        cherry c2 = new cherry(imageView);

        // When
       c2.showCherry();

        // Then
        assertTrue(imageView.isVisible(), "Cherry should be visible");
    }
}