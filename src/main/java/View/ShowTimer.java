package View;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.text.DecimalFormat;


public class ShowTimer {
    private static final int Hours = 0;
    private static final int Minutes = 1;
    private static final int Seconds = 2;


    double maxLength;
    Label[] labels;
    ProgressBar progressBars;


    public ShowTimer(Label[] labels, ProgressBar progressBars) {
        this.labels = labels;
        this.progressBars = progressBars;
    }

    public void updateTime(double seconds) {
        double hours = seconds / 3600;
        double mins = (seconds % 3600) / 60;
        double secs = (seconds % 3600) % 60;

        labels[Hours].setText(Integer.toString((int) hours));
        labels[Minutes].setText(Integer.toString((int) mins));
        labels[Seconds].setText(Integer.toString((int) secs));
        progressBars.setProgress(seconds/maxLength);

    }

    public void initzializeValues(int l) {
        maxLength=l;

    }
}
