package View;

import Model.Uhr;
import com.google.gson.internal.bind.util.ISO8601Utils;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowUhrDigital implements ShowUhr{
    static Uhr uhr;
    Label digitalLabel;

    /**
     * beinhaltet Labels und die Uhr, die angezeigt wird
     */
    public ShowUhrDigital(Uhr uhr, Label digitalTime, Label digitalLabel) {
        ShowUhrDigital.uhr = uhr;
        this.digitalLabel = digitalLabel;
    }


    @Override
    public void showUhr() throws IOException {
    }
}
