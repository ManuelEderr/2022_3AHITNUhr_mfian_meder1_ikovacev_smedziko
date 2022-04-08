package View;

import Model.Uhr;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ShowUhrAnalog extends AnchorPane {
    Uhr uhr;

    Circle clockCircle;

    Line minutesLine;

    Line hourLine;

    Line secondLine;

    StackPane sp;



    public ShowUhrAnalog(Uhr uhr, Circle c, Line minutesLine, Line hourLine, Line secondLine, StackPane sp) {
        this.uhr = uhr;
        this.clockCircle = c;
        this.minutesLine = minutesLine;
        this.hourLine = hourLine;
        this.secondLine = secondLine;
        this.sp = sp;
    }

    public void showUhr() throws IOException {

        long millis = uhr.getCurrentTime().getTime();
        Calendar ca = new GregorianCalendar();
        ca.setTimeInMillis(millis);

        int hour = ca.get(Calendar.HOUR);
        int minute = ca.get(Calendar.MINUTE);
        int second = ca.get(Calendar.SECOND);


        double clockRadius = clockCircle.getRadius();
        double centerX = 150;
        double centerY = 111;


        /*
        //Minutenzeiger
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength
                * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength
                * Math.cos(minute * (2 * Math.PI / 60));
        minutesLine = new Line(centerX, centerY, xMinute, minuteY);
        minutesLine.setStroke(Color.BLUE);

        //Stundenzeiger
        double hLength = clockRadius * 0.5;
        double a = (hour % 12 + minute / 60.0) * (2 * Math.PI / 12);
        double hourX = centerX + hLength
                * Math.sin(a);
        double hourY = centerY - hLength
                * Math.cos(a);
        hourLine = new Line(centerX, centerY, hourX, hourY);
        hourLine.setStroke(Color.GREEN);

         */

        // Draw second hand
        double sLength = (clockRadius * 1.70);
        double xSecond = centerX + sLength
                * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength
                * Math.cos(second * (2 * Math.PI / 60));
        secondLine = new Line(centerX, centerY, xSecond, secondY);
        secondLine.setStroke(Color.BLACK);
        secondLine.setStrokeWidth(5);

        // Draw minute hand
        double mLength = (clockRadius * 1.95);
        double xMinute = centerX + mLength
                * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength
                * Math.cos(minute * (2 * Math.PI / 60));
        minutesLine = new Line(centerX, centerY, xMinute, minuteY);
        minutesLine.setStroke(Color.BLUE);
        minutesLine.setStrokeWidth(5);

        minutesLine.getCursor();


        // Draw hour hand
        double hLength = clockRadius * 1.5;
        double a = (hour % 12 + minute / 60.0) * (2 * Math.PI / 12);
        double hourX = centerX + hLength * Math.sin(a);
        double hourY = centerY - hLength * Math.cos(a);
        hourLine = new Line(centerX, centerY, hourX, hourY);
        hourLine.setStroke(Color.GREEN);
        hourLine.setStrokeWidth(5);



        sp.getChildren().clear();
        sp.getChildren().addAll(minutesLine, hourLine, secondLine, clockCircle);
    }
}