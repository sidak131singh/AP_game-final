package com.example.stickhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginScreen implements Screen{




    public void Start() {

    }
    public Stage display() throws IOException {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScreen.fxml")));
            stage.setTitle("Welcome to stick hero");


            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("sh.css")).toExternalForm());

            //stage.setMaximized(true);
        //stage.setFullScreen(true);
            stage.setScene(scene);
            return stage;

        }
        @FXML
        private AnchorPane login;
        @FXML
        public void onSwitch2Click() throws IOException {
        new switchScreens(login , "hello-view.fxml");

        }


    public void Exit(){

    }
}
