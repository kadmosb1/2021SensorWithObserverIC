package nl.hhs;

import javafx.scene.control.Label;

public class TemperatureLabel extends Label {

    public TemperatureLabel (Sensor sensor) {
        super ();
    }

    public void setText (int temperature) {
        setText (" " + temperature + " *C");
    }
}
