package nl.hhs;

import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class TemperatureLabel extends Label {

    public TemperatureLabel (Sensor sensor) {
        super ();
        setText (sensor.getTemperature ());
    }

    public void setText (int temperature) {
        setText (" " + temperature + " *C");
    }
}
