package com.example.a2022_3ahitnuhr_mfian_meder1_ikovacev_smedziko;

import Model.Uhr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class HelloController {
    public VBox WetterVBox;
    public HBox UhrzeitHBox;
    public HBox DatumHBox;
    public Button DigitaleUhrSwitch;
    public Button AnalogeUhrSwitch;
    public Button StoppuhrSwitch;
    public Button TimerSwitch;
    public Button StartUhrSwitch;
    public Button BinaereUhrSwitch;
    @FXML
    private Label welcomeText;
    @FXML
    protected Label Uhrzeit;
    @FXML
    protected Label Datum;


    Uhr uhr = new Uhr();
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Analog.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Analoge Uhr");
        root.setId("BackgroundWatch1");
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("style.css")));
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Digital.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Digitale Uhr");
        root.setId("BackgroundWatch");
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("style.css")));
        stage.setScene(scene);
        stage.show();
        Uhrzeit();
        Datum();

    }

    public void switchToScene3(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Startseite");
        root.setId("BackgroundWatch2");
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("style.css")));
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Binaer.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Binäre Uhr");
        root.setId("BackgroundWatch3");
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("style.css")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onHelloButtonClick() {
        System.out.println(uhr.getCurrentTime());
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void stoppuhrPopUp(ActionEvent actionEvent) {
    }

    public void timerPopUp(ActionEvent actionEvent) {
    }

    public static void main(String[] args) {
       Date date = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       System.out.println(sdf.format(date));
       Date time = new Date();
       SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
       System.out.println(sdf2.format(time));
    }

    protected void Uhrzeit() {
        Uhr uhr = new Uhr();
        Date time = new Date();
        SimpleDateFormat dtf = new SimpleDateFormat("hh:mm:ss");
        System.out.println(dtf.format(time));

    }

    protected void Datum() {
        Uhr uhr = new Uhr();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(date));
        Datum.setText(String.valueOf(date));

    }
}