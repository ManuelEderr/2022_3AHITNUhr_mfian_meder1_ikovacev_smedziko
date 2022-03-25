package View;

import Model.Uhr;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowUhrDigital implements ShowUhr{
    Uhr uhr;

    public ShowUhrDigital(Uhr uhr) {
        this.uhr = uhr;
    }

    @Override
    public void showUhr() {

    }
}
