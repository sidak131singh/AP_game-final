package com.example.stickhero;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class MainScreen implements Screen {
    @FXML
    private Line stickRect;
    @FXML
    private ImageView hero;

    private double initialHeight;
    private double startHeight;
    private boolean isGrowing = false;

//    @FXML
//    public void initialize() {
//        initialHeight = stickRect.getHeight();
//        startHeight = stickRect.getHeight();
//    }


//    @FXML
//    public void onKeyPressed(KeyEvent event) {
//        //System.out.println("Key Pressed: " + event.getCode());
//        if (event.getCode() == KeyCode.U && !isGrowing) {
//            isGrowing = true;
////            startGrowing(); // Start the growth animation only if it's not already growing
//        }  else if (event.getCode() == KeyCode.F) {
//        // Start the fall animation only if it's growing
//            System.out.println("f");
//        startFalling();
//    }
//        else if(event.getCode()==KeyCode.R){
//            System.out.println("e");
//            isMovingRight = true;
//            startMovingHeroRight();
//
//        }
//
//    }





    private boolean touch = false;
    private boolean hasFallen = false;
    private double stickLength = 0;
    private Timeline timeline;
    private long pressTime;

    @FXML
    public void startGrowing() {
        if (!hasFallen && !touch) {
            pressTime = System.currentTimeMillis();
            timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
                long elapsedTime = System.currentTimeMillis() - pressTime;
                if (elapsedTime < 1200 && stickLength < 10) { // Limit growth to 10 and 1.2 seconds
                    stickLength += 0.05;
                    stickRect.setEndY(stickRect.getEndY() - 0.05);
                }
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            touch = true;
        }
    }

    @FXML
    public void startFalling(MouseEvent event) {
        if (!hasFallen && touch) {
            double initialEndY = stickRect.getEndY();
            long elapsedTime = System.currentTimeMillis() - pressTime;
            if (timeline != null) {
                timeline.stop();
            }

            Rotate rotate = new Rotate(0, stickRect.getStartX(), stickRect.getStartY());

            Timeline fallTimeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(rotate.angleProperty(), 90))
            );

            fallTimeline.setOnFinished(e -> {
                System.out.println("Rotation finished!");
                stickRect.setEndY(initialEndY); // Maintain the stick's current height
                touch = false;
                hasFallen = true; // Prevent further interaction after falling
            });

            stickRect.getTransforms().add(rotate);
            fallTimeline.play();
        }
    }




//    @FXML
//    public void onKeyReleased() {
//        if (event.g == KeyCode.U) {
//            isGrowing = false;
//            startFalling();
//        }
//        if (event.getCode() == KeyCode.R) {
//            isMovingRight= false;
//        }
//    }




    @FXML
    private double STICK_SPEED = 0.00005;
//    @FXML
//    public void startGrowing() {
//
//
//        if (!touch) {
//            timeline = new Timeline(new KeyFrame(Duration.millis(0.5), event -> {
//                stickLength += STICK_SPEED;
//                stickRect.setEndY(stickRect.getEndY() - stickLength);
//            }));
//            timeline.setCycleCount(Timeline.INDEFINITE);
//            timeline.play();
////           stickRect.setStartY(stickRect.getEndY()-1.1);
//            touch = true;
//        }
//    }
//@FXML
//
//
//    private long pressTime = 0;
//    private static final double MAX_LENGTH = 400;
//    private static final double GROWTH_RATE = 0.1; // Adjust the growth rate as needed
//
//    @FXML
//    public void startGrowing() {
//        if (!touch) {
//            pressTime = System.currentTimeMillis();
//            timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
//                long elapsedTime = System.currentTimeMillis() - pressTime;
//                stickLength = Math.min(MAX_LENGTH, elapsedTime * GROWTH_RATE);
//                stickRect.setEndY(stickRect.getStartY() - stickLength);
//            }));
//            timeline.setCycleCount(Timeline.INDEFINITE);
//            timeline.play();
//            touch = true;
//        }
//    }
//
//    @FXML
//    public void startFalling(MouseEvent event) {
//        if (touch) {
//            double initialEndY = stickRect.getEndY();
//            long elapsedTime = System.currentTimeMillis() - pressTime;
//            if (timeline != null) {
//                timeline.stop();
//            }
//
//            Rotate rotate = new Rotate(0, stickRect.getStartX(), stickRect.getStartY());
//
//            Timeline fallTimeline = new Timeline(
//                    new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
//                    new KeyFrame(Duration.seconds(1), new KeyValue(rotate.angleProperty(), 90))
//            );
//
//            fallTimeline.setOnFinished(e -> {
//                System.out.println("Rotation finished!");
//                stickRect.setEndY(stickRect.getEndY() + stickLength); // Maintain the stick's current height
//                touch = false;
//            });
//
//            stickRect.getTransforms().add(rotate);
//            fallTimeline.play();
//        }
//    }





    //    @FXML
//    public void startFalling() {
//        Rotate rotate = new Rotate(0, stickRect.getStartX(), stickRect.getStartY());
//        Scale scale = new Scale(8, 1, stickRect.getStartX(), stickRect.getStartY());
//
//        // Create a timeline for the rotation
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0),new KeyValue(scale.xProperty(), 8), new KeyValue(scale.yProperty(), 1)),
//                new KeyFrame(Duration.seconds(1), new KeyValue(rotate.angleProperty(), 90),new KeyValue(scale.xProperty(), 8), new KeyValue(scale.yProperty(), 1))
//        );
//
//        // Set an event handler for when the rotation is finished
//        timeline.setOnFinished(event -> {
//            System.out.println("Rotation finished!");
//            // Add any additional logic you want to execute after rotation
//        });
//
//        // Apply the rotation to the line
//        stickRect.getTransforms().add(rotate);
//
//        // Start the timeline
//        timeline.play();
//    }
//@FXML
//public void startFalling() {
//    if (touch) { // Only initiate fall if the stick was growing before
//        double endYBeforeFall = stickRect.getEndY(); // Store the initial end Y position
//        if (timeline != null) {
//            timeline.stop(); // Stop the growing timeline
//        }
//
//        Rotate rotate = new Rotate(0, stickRect.getStartX(), stickRect.getStartY());
//        Scale scale = new Scale(1, 1, stickRect.getStartX(), stickRect.getStartY());
//
//        // Create a timeline for the rotation
//        Timeline fallTimeline = new Timeline(
//                new KeyFrame(Duration.ZERO,
//                        new KeyValue(rotate.angleProperty(), 0),
//                        new KeyValue(scale.xProperty(), 1),
//                        new KeyValue(scale.yProperty(), 1)),
//                new KeyFrame(Duration.seconds(1),
//                        new KeyValue(rotate.angleProperty(), 90),
//                        new KeyValue(scale.xProperty(), 1),
//                        new KeyValue(scale.yProperty(), 1))
//        );
//
//        // Set an event handler for when the rotation is finished
//        fallTimeline.setOnFinished(event -> {
//            System.out.println("Rotation finished!");
//            stickRect.setEndY(endYBeforeFall); // Reset the stick's end Y position after rotation
//            touch = false; // Reset the touch flag
//        });
//
//        // Apply the rotation to the line
//        stickRect.getTransforms().add(rotate);
//
//        // Start the timeline
//        fallTimeline.play();
//    }
//}




    private boolean isMovingRight = false;
    double speed = 5.0;
//    private void startMovingHeroRight() {
//        AnimationTimer timer = new AnimationTimer() {
//            double currentX = hero.getX();
//            long lastUpdateTime = 0;
//
//            @Override
//            public void handle(long now) {
//                if (now - lastUpdateTime >= 30_000_000) { // Adjust the duration (in nanoseconds) for smoother movement
//                    currentX += speed; // Increment the x-coordinate
//                    hero.setX(currentX); // Set the updated x-coordinate
//                    lastUpdateTime = now;
//                }
//                // Add a condition to stop moving when reaching a certain position or a released key
//                if (currentX >= stickRect.getX() + stickRect.getWidth() || !isMovingRight) {
//                    stop();
//                }
//            }
//        };
//        timer.start();
//    }

    @FXML
    public Stage display() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage.setTitle("Welcome to stick hero");



        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

        stage.setFullScreen(true);
        stage.setScene(scene);
        return stage;
    }





}