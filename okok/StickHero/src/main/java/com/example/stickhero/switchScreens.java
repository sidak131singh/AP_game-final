package com.example.stickhero;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.IOException;
import java.util.Objects;

public class switchScreens {
    public switchScreens(AnchorPane CAP,String fxml)throws IOException {
        AnchorPane NAP = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        CAP.getChildren().removeAll();
        CAP.getChildren().setAll(NAP);
    }

}
