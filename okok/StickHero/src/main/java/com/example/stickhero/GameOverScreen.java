package com.example.stickhero;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameOverScreen implements Screen{
    private Score s;

    public Stage display() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("endScreen.fxml")));
        stage.setTitle("Welcome to stick hero");


        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

        //stage.setMaximized(true);
//        stage.setFullScreen(true);
        stage.setScene(scene);
        return stage;
    }
    public Score dispcurrentscore(){


        return null;
    }
public Score disphighscore(){
        return null;
}

    public void restart(){}
    public void resume(){

    }

    public void exit(){}

}
