package View;

import javafx.scene.control.Label;

public class showEvent {
    String temperature;
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
        tempLabel.setText(temperature + "°");
        teimzone.setText(Integer.toString(timezone));
    }
}
