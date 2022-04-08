package View;

import Model.Uhr;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ShowUhrBinary implements ShowUhr {
    String newTimeInBin;
    String oldTimeinBin;
    Circle[] circles;

    public ShowUhrBinary(Circle[] circlesToUse) {
        newTimeInBin = "";
        oldTimeinBin = "0000000000000000";
        circles = circlesToUse;
    }

    @Override
    public void showUhr() {
        for (int i = 0; i < 16; i++) {
            if (oldTimeinBin.charAt(i) == '0') {
                if (newTimeInBin.charAt(i) == '1') {
                    circles[i].setFill(javafx.scene.paint.Color.RED);
                }
            }
            else if(oldTimeinBin.charAt(i)== '1'){
                if (newTimeInBin.charAt(i)=='0'){
                    circles[i].setFill(Color.BLACK);
                }
            }
        }
        oldTimeinBin = newTimeInBin;
    }

    public void upadte(long newTime) {
        Date date = new Date(newTime);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        newTimeInBin = String.format("%4s", Integer.toString(calendar.get(Calendar.HOUR_OF_DAY), 2)).replace(' ', '0');
        newTimeInBin += String.format("%6s", Integer.toString(calendar.get(Calendar.MINUTE), 2)).replace(' ', '0');
        newTimeInBin += String.format("%6s", Integer.toString(calendar.get(Calendar.SECOND), 2)).replace(' ', '0');
        showUhr();
    }

}

