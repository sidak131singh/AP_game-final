package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameOverScreen{
    private Score s;
    @FXML
    Label gmscore;
    @FXML
    Label gmcherry;
    boolean iscalled= false;

    MainScreen m = new MainScreen();

    int mscore = m.scores.getScore();
    int gmcherrycount = m.cherryCount;
    String Stringscore = Integer.toString(mscore);




    public Stage display(int score,int cherry) throws IOException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("endScreen.fxml"));
        Parent root = loader.load();

        GameOverScreen gameOverScreen = loader.getController();
        gameOverScreen.setgmscore(score);
        gameOverScreen.setgmcherry(cherry);// Pass the score value to setgmscore

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

        stage.setScene(scene);
        return stage;
    }
    public void setgmscore(int score) {

        try {  //String Stringscore = Integer.toString(mscore);
            gmscore.setText(String.valueOf(score));
        } catch (NullPointerException e) {

        }
    }
    public String getgmscore() {
        String x = gmscore.getText();
        return x ;
    }

        public void setgmcherry(int c){

            try {  //String Stringscore = Integer.toString(mscore);
                gmcherry.setText(String.valueOf(c));
            }catch (NullPointerException e){

            }


    }
    public String  getgmcherry(){
       // String chers = Integer.toString(gmcherrycount);

            gmcherrycount--;
            String chers = Integer.toString(gmcherrycount);


        return chers;
    }

    public Score disphighscore(){
        return null;
    }
    @FXML
    public void restart(ActionEvent event) {
        showMainScreen(event);
    }

   void showMainScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene mainScreenScene = new Scene(root);

            MainScreen mainScreenController = fxmlLoader.getController();
            mainScreenController.manageCherries();
            mainScreenController.generatePillars();

            mainScreenScene.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.U) {
                    mainScreenController.onKeyPressed(e);
                } else if (e.getCode() == KeyCode.F) {
                    mainScreenController.onKeyPressed(e);
                }
            });

            mainScreenScene.setOnKeyReleased(e -> {
                if (e.getCode() == KeyCode.U) {
                    mainScreenController.onKeyReleased(e);
                }
            });

            Stage mainScreenStage = new Stage();
            mainScreenStage.setScene(mainScreenScene);
            mainScreenStage.setTitle("Main Screen");
            mainScreenStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void revive(ActionEvent event) throws IOException {


        showMain(event,getgmscore(),getgmcherry());
            }









    void showMain(ActionEvent event, String score , String cherry) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene mainScreenScene = new Scene(root);

            MainScreen mainScreenController = fxmlLoader.getController();
            mainScreenController.manageCherries();
            mainScreenController.generatePillars();

            mainScreenController.scorefx.setText(score);
            mainScreenController.maincherry.setText(cherry);
            int p = Integer.parseInt(score);
            m.score += p;

            mainScreenScene.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.U) {
                    mainScreenController.onKeyPressed(e);
                } else if (e.getCode() == KeyCode.F) {
                    mainScreenController.onKeyPressed(e);
                }
            });

            mainScreenScene.setOnKeyReleased(e -> {
                if (e.getCode() == KeyCode.U) {
                    mainScreenController.onKeyReleased(e);
                }
            });

            Stage mainScreenStage = new Stage();
            mainScreenStage.setScene(mainScreenScene);
            mainScreenStage.setTitle("Main Screen");
//
//            Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            loginStage.close();

            mainScreenStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(){}

}
