package Model;


import java.sql.Timestamp;

public class Uhr {

    private Timestamp CurrentTime;
    private Event[] event;
    private Timestamp[] Wecker;
    private String Temperatur;
    private String[] bilderFuerWetter;

    public Timestamp getCurrentTime() {
        return CurrentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        CurrentTime = currentTime;
    }

    public Event[] getEvent() {
        return event;
    }

    public void setEvent(Event[] event) {
        this.event = event;
    }

    public Timestamp[] getWecker() {
        return Wecker;
    }

    public void setWecker(Timestamp[] wecker) {
        Wecker = wecker;
    }

    public String getTemperatur() {
        return Temperatur;
    }

    public void setTemperatur(String temperatur) {
        Temperatur = temperatur;
    }

    public String[] getBilderFuerWetter() {
        return bilderFuerWetter;
    }

    public void setBilderFuerWetter(String[] bilderFuerWetter) {
        this.bilderFuerWetter = bilderFuerWetter;
    }
}