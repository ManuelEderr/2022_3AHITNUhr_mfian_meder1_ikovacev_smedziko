package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContentB extends AnchorPane {

    public ContentB(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentB.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}