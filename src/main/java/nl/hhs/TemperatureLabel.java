package nl.hhs;

import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class TemperatureLabel extends Label implements Observer {

    public TemperatureLabel (Sensor sensor) {
        super ();
        setText (sensor.getTemperature ());
        sensor.addObserver (this);
    }

    public void setText (int temperature) {
        setText (" " + temperature + " *C");
    }

    @Override
    public void update (Observable o, Object arg) {
        setText ((int) arg);
    }
}
