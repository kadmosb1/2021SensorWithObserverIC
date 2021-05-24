package nl.hhs;

import javafx.scene.control.Button;

public class TemperatureButton extends Button {

    Sensor sensor;

    public TemperatureButton (Sensor sensor) {
        super ();
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
}
