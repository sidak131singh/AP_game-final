package com.example.stickhero;

import com.example.stickhero.Hero;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class cherry {
    private ImageView imageView;
    private boolean collision;

    public cherry(ImageView imageView) {
        this.imageView = imageView;
        this.collision = false;
    }

    public boolean isCollision() {
        return collision;
    }

    public void hideCherry() {
        imageView.setVisible(false);
    }

    public void showCherry() {
        imageView.setVisible(true);
    }

    public void startCollisionCheck(Hero hero) {
        Timeline cherryCheck = new Timeline(
                new KeyFrame(Duration.ZERO, e -> checkCherryCollision(hero)),
                new KeyFrame(Duration.seconds(0.1)) // Adjust the duration as needed
        );
        cherryCheck.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
        cherryCheck.play();
    }

    public void checkCherryCollision(Hero hero) {
        Bounds heroBounds = Hero.hero.getBoundsInParent();
        Bounds cherryBounds = imageView.getBoundsInParent();

        if (heroBounds.intersects(cherryBounds)) {
            collision = true;
            hideCherry();
        }
    }
}
