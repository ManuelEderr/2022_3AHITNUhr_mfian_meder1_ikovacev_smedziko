package View;

import Model.Uhr;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ShowUhrAnalog extends AnchorPane {
    Uhr uhr;

    Circle clockCircle;

    Line minutesLine;

    Line hourLine;

    Line secondLine;

    StackPane sp;

    int hour;
    int minute;
    int second;

    /**
     * Konstruktor für die einzelnen Zeiger der Uhr
     */
    public ShowUhrAnalog(Uhr uhr, Circle c, Line minutesLine, Line hourLine, Line secondLine, StackPane sp) {
        this.uhr = uhr;
        this.clockCircle = c;
        this.minutesLine = minutesLine;
        this.hourLine = hourLine;
        this.secondLine = secondLine;
        this.sp = sp;
    }

    /**
     * Die Uhr wird angezeigt und die Position der Zeiger wird berechnet.
     * @throws IOException
     */
    public void showUhr() throws IOException {

        double clockRadius = Math.min(sp.getWidth(), sp.getHeight()) * 0.8 * 0.5;
        double centerX = sp.getWidth() / 2;
        double centerY = sp.getHeight() / 2;





        clockCircle = new Circle(centerX, centerY, clockRadius);
        clockCircle.setFill(Color.WHITE);
        clockCircle.setStroke(Color.BLACK);

        /**
         * Position des Sekundenzeigers wird berechnet
         */
        double sLength = (clockRadius * 0.95);
        double xSecond = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double ySecond = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        secondLine = new Line(centerX, centerY, xSecond, ySecond);
        secondLine.setStroke(Color.BLACK);
        secondLine.setStrokeWidth(5);

        /**
         * Position des Minutenzeigers wird berechnet
         */
        double mLength = clockRadius * 0.8;
        double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double yMinute = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        minutesLine = new Line(centerX, centerY, xMinute, yMinute);
        minutesLine.setStroke(Color.BLUE);
        minutesLine.setStrokeWidth(5);

        minutesLine.getCursor();

        /**
         * Position des Stundnezeigers wird berechnet
         */
        double hLength = clockRadius * 0.5;
        double a = (hour % 12 + minute / 60.0) * (2 * Math.PI / 12);
        double xHour = centerX + hLength * Math.sin(a);
        double yHour = centerY - hLength * Math.cos(a);
        hourLine = new Line(centerX, centerY, xHour, yHour);
        hourLine.setStroke(Color.GREEN);
        hourLine.setStrokeWidth(5);



        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                sp.getChildren().clear();
                sp.getChildren().addAll(clockCircle, hourLine, minutesLine, secondLine);
            }
        });



    }

    /**
     * Automatische Aktualisierung der analogen Uhrzeit
     * @throws IOException
     */
    public void upadte(Uhr uhr) throws IOException {
        this.uhr = uhr;

        long millis = uhr.getCurrentTime();
        Calendar ca = new GregorianCalendar();
        ca.setTimeInMillis(millis);

        hour = ca.get(Calendar.HOUR);
        minute = ca.get(Calendar.MINUTE);
        second = ca.get(Calendar.SECOND);



        showUhr();
    }
}