package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContentA extends AnchorPane {

    public ContentA(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContentA.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
