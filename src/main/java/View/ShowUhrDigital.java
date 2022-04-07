package View;

import Model.Uhr;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowUhrDigital implements ShowUhr{
    Uhr uhr;
    Label digitalLabel;

    public ShowUhrDigital(Uhr uhr, Label digitalLabel) {
        this.uhr = uhr;
        this.digitalLabel = digitalLabel;
    }


//    public static void main(String[] args) {
//
//        System.out.println();
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//        System.out.println(dtf.format(LocalDateTime.now()));
//
//
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        System.out.println(dtf2.format(LocalDateTime.now()));
//    }


    @Override
    public void showUhr() throws IOException {
        digitalLabel.setText(uhr.getCurrentTime().toString());
    }
}
