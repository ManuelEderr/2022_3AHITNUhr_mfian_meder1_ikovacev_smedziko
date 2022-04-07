package View;

import Model.Uhr;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;


public class ShowUhrAnalog extends AnchorPane {
    Uhr uhr;

    Circle clockCircle;

    Line minutesLine;

    Line hourLine;

    public ShowUhrAnalog(Uhr uhr, Circle c, Line minutesLine, Line hourLine) {
        this.uhr = uhr;
        this.clockCircle = c;
        this.minutesLine = minutesLine;
        this.hourLine = hourLine;
    }

    public void showUhr(int hour, int minute) throws IOException {



        double clockRadius = 250 * 0.8 * 0.5;
        double centerX = 50;
        double centerY = 50;

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
        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength
                * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength
                * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength
                * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength
                * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(mLine, hLine);
    }
}