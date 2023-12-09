package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainScreen implements Screen {
    @FXML
   Rectangle stick;
    @FXML
    ImageView cherry;
    @FXML
    ImageView cherry1;
    @FXML
    ImageView cherry2;
    @FXML
    ImageView cherry3;
    @FXML
    ImageView cherry4;
   int cherryCount;

    public int getCherryCount() {
        return cherryCount;
    }

    public                 int index=0;

    Stick stickx = new Stick(stick);
    @FXML
    ImageView hero;
    Hero herox = new Hero(hero);

    boolean isGrowing = false;
    boolean canGrowAndFall = true;
    boolean hasRotated = false;
    int score=0;
    Score scores = new Score(score);
    private boolean hasFalled = false;

    private int pillarsCrossed = 0;
    private boolean cherryCollision = false;
@FXML
 Label maincherry;

    public void revivePlayer(ActionEvent event) throws IOException {
        if (cherryCount > 0) {
            cherryCount--;
             String c = Integer.toString(cherryCount);
            GameOverScreen gom = new GameOverScreen();
             gom.revive(event);
            scorefx.setText(gom.getgmscore());
            maincherry.setText(c);
            System.out.println("revive player called");
            Stage gameOverStage = (Stage) gamePane.getScene().getWindow();
            gameOverStage.close();
        }
    }


    public void manageCherries() {

        cherry.setVisible(false);
        cherry1.setVisible(false);
        cherry2.setVisible(false);
        cherry3.setVisible(false);
        cherry4.setVisible(false);


        int randomAppearance = (int) (Math.random() * 2);

        if (randomAppearance == 1) {

            int randomCherry = (int) (Math.random() * 5);

            switch (randomCherry) {
                case 0:
                    cherry.setVisible(true);
                    break;
                case 1:
                    cherry1.setVisible(true);
                    break;
                case 2:
                    cherry2.setVisible(true);
                    break;
                case 3:
                    cherry3.setVisible(true);
                    break;
                case 4:
                    cherry4.setVisible(true);
                    break;
                default:

                    break;
            }
        }
    }


    @FXML
    public void onKeyPressed(KeyEvent event) {

        if (event.getCode() == KeyCode.U && !hasRotated && canGrowAndFall) {

            stickx.startGrowing(stick);
            startCherryCollisionCheck();
            startCherryCollisionCheck1();
            startCherryCollisionCheck2();
            startCherryCollisionCheck3();
            startCherryCollisionCheck4();

        }
        else if(event.getCode()==KeyCode.F){

            herox.flip(hero);
            if (cherryCollision) {
                cherryCount++;
              cherryCollision= false;
            }
            checkCherryCollision();
            checkCherryCollision1();
            checkCherryCollision2();
            checkCherryCollision3();
            checkCherryCollision4();

        }
    }
    private void startCherryCollisionCheck() {
        Timeline cherryCheck = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    checkCherryCollision();
                }),
                new KeyFrame(Duration.seconds(0.1))
        );
        cherryCheck.setCycleCount(Timeline.INDEFINITE);
        cherryCheck.play();
    }
    private void checkCherryCollision() {

        Bounds heroBounds = hero.getBoundsInParent();
        Bounds cherryBounds = cherry.getBoundsInParent();

        if (heroBounds.intersects(cherryBounds)) {

            cherryCollision = true;
            cherry.setVisible(false);


        }

    }
    private void startCherryCollisionCheck1() {
        Timeline cherryCheck1 = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    checkCherryCollision();
                }),
                new KeyFrame(Duration.seconds(0.1))
        );
        cherryCheck1.setCycleCount(Timeline.INDEFINITE);
        cherryCheck1.play();
    }
    private void checkCherryCollision1() {

        Bounds heroBounds1 = hero.getBoundsInParent();
        Bounds cherryBounds1 = cherry1.getBoundsInParent();

        if (heroBounds1.intersects(cherryBounds1)) {

            cherryCollision = true;
            cherry1.setVisible(false);


        }

    }
    private void startCherryCollisionCheck2() {
        Timeline cherryCheck2 = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    checkCherryCollision();
                }),
                new KeyFrame(Duration.seconds(0.1))
        );
        cherryCheck2.setCycleCount(Timeline.INDEFINITE);
        cherryCheck2.play();
    }
    private void checkCherryCollision2() {

        Bounds heroBounds2 = hero.getBoundsInParent();
        Bounds cherryBounds2 = cherry2.getBoundsInParent();

        if (heroBounds2.intersects(cherryBounds2)) {

            cherryCollision = true;
            cherry2.setVisible(false);


        }

    }
    private void startCherryCollisionCheck3() {
        Timeline cherryCheck3 = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    checkCherryCollision();
                }),
                new KeyFrame(Duration.seconds(0.1))
        );
        cherryCheck3.setCycleCount(Timeline.INDEFINITE);
        cherryCheck3.play();
    }
    private void checkCherryCollision3() {

        Bounds heroBounds3 = hero.getBoundsInParent();
        Bounds cherryBounds3 = cherry3.getBoundsInParent();

        if (heroBounds3.intersects(cherryBounds3)) {

            cherryCollision = true;
            cherry3.setVisible(false);


        }

    }
    private void startCherryCollisionCheck4() {
        Timeline cherryCheck4 = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    checkCherryCollision();
                }),
                new KeyFrame(Duration.seconds(0.1))
        );
        cherryCheck4.setCycleCount(Timeline.INDEFINITE);
        cherryCheck4.play();
    }
    private void checkCherryCollision4() {

        Bounds heroBounds4 = hero.getBoundsInParent();
        Bounds cherryBounds4 = cherry1.getBoundsInParent();

        if (heroBounds4.intersects(cherryBounds4)) {

            cherryCollision = true;
            cherry4.setVisible(false);


        }

    }
    @FXML
    public void onKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.U && !hasRotated && canGrowAndFall) {

            isGrowing = false;
            stickx.startFalling(stick);
            hasRotated = true;
            canGrowAndFall = false;

            herox.Move(stick.getHeight(), hero);

            Timeline t = new Timeline(new KeyFrame(Duration.seconds(100000), evt -> {
                herox.Move(stick.getHeight(), hero);
            }));
            t.play();
            double time = stick.getHeight() / herox.getSpeed();
            if(stick.getHeight()<(rectangles[score+1].getLayoutX() + (rectangles[score].getWidth()/2) -5 -rectangles[score].getLayoutX())-rectangles[score].getWidth()||
                    stick.getHeight()>(rectangles[score+1].getLayoutX()+rectangles[score+1].getWidth()+ (rectangles[score].getWidth()/2)-(rectangles[score].getLayoutX()+rectangles[score].getWidth()))){
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time), evt -> {
                    herox.startFalling(hero);
                    hasFalled = true;
                }));



                timeline.play();
                Timeline ti = new Timeline(new KeyFrame(Duration.seconds(time+4), evt -> {
                    displayGameOverScreen();
                    hasFalled = true;
                }));
                ti.play();
                displayScore();

            }
            else{
                Timeline ax = new Timeline(new KeyFrame(Duration.seconds(time), evt -> {
                    int currentPillarIndex=0;
                    index=currentPillarIndex;
                    int pillarIndex = 0;
                    TranslateTransition shiftstick = new TranslateTransition(Duration.millis(1000), stick);
                    shiftstick.setToX(stick.getTranslateX() - 550);
                    double newHeroX = rectangles[currentPillarIndex].getLayoutX() + rectangles[currentPillarIndex].getWidth() ;
                    shiftstick.play();
                    TranslateTransition shifthero = new TranslateTransition(Duration.millis(1000), hero);
                    shifthero.setToX(pillarIndex);
                    int a = 6;
                    for(int i =0; i<20;i++) {
                        if (pillarIndex <= 5) {
                            shifthero.setToX(pillarIndex);
                        } else {
                            shifthero.setToX(pillarIndex - a);
                            a+=a+6;
                        }

                    }
                    shifthero.play();
                    manageCherries();
                    int check = 99;
                    int destinationPillarIndex = pillarIndex + 1;
                    for (int i = 0; i < check; i++) {

                        currentPillarIndex = destinationPillarIndex -1 ;
                        if (currentPillarIndex >= 0 && currentPillarIndex + 1 < rectangles.length) {

                            TranslateTransition shiftIn = new TranslateTransition(Duration.millis(1000), rectangles[currentPillarIndex]);
                            shiftIn.setToX((rectangles[currentPillarIndex].getTranslateX() - 350)+10);
                            shiftIn.play();



                            TranslateTransition shiftOut = new TranslateTransition(Duration.millis(1000), rectangles[currentPillarIndex + 1]);

                            shiftOut.setToX((rectangles[currentPillarIndex + 1].getTranslateX() - 350)+10);

                            shiftOut.play();
                            shiftOut.setOnFinished(Aevent->reposition());



                        }
                        if (currentPillarIndex == 1) {
                            TranslateTransition shiftIn3 = new TranslateTransition(Duration.millis(1000), rectangles[currentPillarIndex]);


                            shiftIn3.setToX((rectangles[currentPillarIndex].getTranslateX() - 350));

                            shiftIn3.play();



                        }
                        destinationPillarIndex=destinationPillarIndex+1;


                    }
//


                    isGrowing = true;
//                        stickx.startFalling(stick);
                    hasRotated = false;
                    canGrowAndFall = true;
                    stick.getTransforms().clear();

                  updateScore();

                    pillarIndex++;


                })

                );
                ax.play();}
        }
    }

    @FXML
    Label scorefx ;



    private void displayGameOverScreen() {
        if (hasFalled) {
            try {
            GameOverScreen gg = new GameOverScreen();

               gg.setgmscore(score);
               gg.setgmcherry(cherryCount);
                Stage gameOverStage = gg.display(score,cherryCount);
                gameOverStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String toString(int score) {
        return ("score= "+ score);
    }

    @FXML
    private AnchorPane gamePane; // Reference to the AnchorPane in the FXML file


    Rectangle[] rectangles = new Rectangle[100];
    public void generatePillars() {
        double xPosition = 79;
        double gapWidth = 330;
        Group G1 = new Group();

        for (int i = 0; i < 100; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setWidth(Math.random() * 50 + 90);
            rectangles[i].setHeight(211);
            rectangles[i].setLayoutY(200);
            rectangles[i].setLayoutX(xPosition);

            xPosition += gapWidth;
            G1.getChildren().add(rectangles[i]);
        }


        gamePane.getChildren().add(G1);


    }
    int pillarIndex = 1;
    public void movement(){
        TranslateTransition shiftStick = new TranslateTransition(Duration.millis(1000), stick);
        shiftStick.setToX(stick.getTranslateX() - 450);
        shiftStick.play();
        TranslateTransition shifthero = new TranslateTransition(Duration.millis(1000), hero);
        shifthero.setToX(hero.getX()-350);
        shifthero.play();


        int p=0;
        int check = 2 ;
        for(int i = 0 ; i < check ; i++ ){
            if (p >= 1) {

                TranslateTransition shiftOut = new TranslateTransition(Duration.millis(1000), rectangles[p- 1]);
                shiftOut.setToX(rectangles[p - 1].getTranslateX() - 350);
                shiftOut.play();
            }


            TranslateTransition shiftIn = new TranslateTransition(Duration.millis(1000), rectangles[p]);

            shiftIn.setToX(rectangles[p].getTranslateX() - 350);
            shiftIn.play();
            p++;
        }
    }
    @FXML
    public Stage display() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage.setTitle("Welcome to stick hero");
        MainScreen mm = new MainScreen();


        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

        stage.setFullScreen(true);
        stage.setScene(scene);
        return stage;
    }

    public void updateScore(){
        score++;
    }
    public void updateCherryCount(){
        cherryCount++;
    }



    private void growStick() {

        hasRotated = false;
        canGrowAndFall = true;
        // hasHeroReachedNextPillar = false;
    }
    private void reposition() {
        String Stringscore = Integer.toString(score);
        String Stringcherry = Integer.toString(cherryCount);

        scorefx.setText(Stringscore);
        maincherry.setText(Stringcherry);
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), hero);
        hero.setTranslateX(score-15);
        //translate.setToX(rectangles[0].getLayoutX() + rectangles[0].getWidth() - hero.getLayoutX() -10);
        translate.setCycleCount(1);
        double ycord=stick.getHeight();

        // Set an event handler to be executed after the translation is finished
        translate.setOnFinished(event -> {
            // Decrease the stick's height to zero
            stick.getTransforms().clear();
            double ht=stick.getHeight();
            stick.setHeight(0);
            double xx= stick.getLayoutX();


            stick.setTranslateX(score-15);
            growStick();

        });

        translate.play();

    }   public void saveScore() {
//        loadScores();
        scoresList.add(score);


        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("hs.txt"));
            outputStream.writeInt(score);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public void setscore(int score){
        String s = Integer.toString(score);
        scorefx.setText(s);

}
public void setcherry(int c){
        String xd = Integer.toString(c);
        maincherry.setText(xd);
}


    public void displayScore() {

//        loadScores();


        int maxScore = scoresList.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Maximum score : " + maxScore);

    }
    private List<Integer> scoresList = new ArrayList<>();
//    private void loadScores() {
//        try {
//            // Read the list of scores from the file
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("hs.txt"));
//            Object obj = inputStream.readObject();
//
//            if (obj instanceof List) {
//                scoresList = (List<Integer>) obj;
//            }
//
//            inputStream.close();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public Stage Mdisplay(int  score, int cherry) throws IOException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent rt = loader.load();

    MainScreen mainScreen = loader.getController();
    setscore(score);
    setcherry(cherry);



        Scene scene = new Scene(rt);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

        stage.setScene(scene);
        return stage;
    }


}