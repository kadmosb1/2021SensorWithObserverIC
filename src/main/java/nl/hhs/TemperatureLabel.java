package nl.hhs;

import javafx.scene.control.Label;

public class TemperatureLabel extends Label {

    public TemperatureLabel (int temperature) {
        super ();
        setText (temperature);
    }

    public void setText (int temperature) {
        setText (" " + temperature + " *C");
    }
}
