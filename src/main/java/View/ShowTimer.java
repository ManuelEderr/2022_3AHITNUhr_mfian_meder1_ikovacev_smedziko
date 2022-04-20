package View;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class ShowTimer {
    private static final int Hours = 0;
    private static final int Minutes = 1;
    private static final int Seconds = 2;

    int hours;
    int mins;
    int secs;

    Label[] labels;
    ProgressBar[] progressBars;

    public ShowTimer(Label[] labels, ProgressBar[] progressBars){
    this.labels=labels;
    this.progressBars=progressBars;
    }

    public void updateTime(int seconds){
        hours=seconds/3600;
        mins=(seconds-hours*3600)/60;
        secs=(seconds%3600)%60;
        labels[Hours].setText(Integer.toString(hours));
        labels[Minutes].setText(Integer.toString(mins));
        labels[Seconds].setText(Integer.toString(secs));
    }
}
