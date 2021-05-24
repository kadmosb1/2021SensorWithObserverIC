package nl.hhs;

import javafx.scene.control.Button;

import java.util.Observable;
import java.util.Observer;

public class TemperatureButton extends Button implements Observer {

    Sensor sensor;

    public TemperatureButton (Sensor sensor) {
        super ();
        sensor.addObserver (this);
        setColor (sensor.getTemperature ());
    }

    private void setColor (int temperature) {

        if (temperature > 27) {
            setStyle ("-fx-base: red;");
        }
        else if (temperature > 10) {
            setStyle ("-fx-base: orange;");
        }
        else if (temperature >= 0) {
            setStyle ("-fx-base: green;");
        }
        else {
            setStyle ("-fx-base: blue;");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setColor ((Integer) arg);
    }
}
