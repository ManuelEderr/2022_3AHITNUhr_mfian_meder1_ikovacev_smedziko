package View;

import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class showEvent {
    String temperature;
    double temperatureInteger;
    Label tempLabel;
    Label teimzone;
    int timezone;

    public showEvent(String temperature, int timezone,  Label tempLabel, Label teimzone) {
        this.temperature = temperature;
        this.tempLabel = tempLabel;
        this.teimzone = teimzone;
        this.timezone = timezone;
    }

    public void eventShow(){
        temperatureInteger = round(Double.parseDouble(temperature) - 273.15, 2);
        tempLabel.setText(temperatureInteger + "°");
        teimzone.setText(Integer.toString(timezone));
    }




    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}

