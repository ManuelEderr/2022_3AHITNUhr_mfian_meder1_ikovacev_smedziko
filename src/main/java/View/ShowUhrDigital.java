package View;

import Model.Uhr;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowUhrDigital implements ShowUhr{
    Uhr uhr;

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dtf2.format(LocalDateTime.now()));
    }
    public ShowUhrDigital(Uhr uhr) {
        this.uhr = uhr;
    }

    @Override
    public void showUhr() {

    }
}
