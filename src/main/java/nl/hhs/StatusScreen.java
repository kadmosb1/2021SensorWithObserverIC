package nl.hhs;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

class EventHandlerClose implements EventHandler<WindowEvent> {

    Sensor sensor;
    TemperatureButton button;
    TemperatureLabel label;

    public EventHandlerClose (Sensor sensor, TemperatureButton button, TemperatureLabel label) {
        this.sensor = sensor;
        this.button = button;
        this.label = label;
    }

    @Override
    public void handle (WindowEvent windowEvent) {
    }
}

public class StatusScreen extends Stage {

    public StatusScreen(int x, int y, Sensor sensor) {

        setResizable (false);

        this.setX (x - 250);
        this.setY (y - 31);

        Pane rootPane = new Pane();
        setTitle ("Status");
        rootPane.setMinSize (100, 100);

        HBox hBox = new HBox ();
        hBox.setPrefHeight (100);
        hBox.setAlignment (Pos.CENTER_LEFT);

        TemperatureLabel label = new TemperatureLabel (sensor);
        label.setFont (new Font ("Arial", 45));
        label.setText (sensor.getTemperature ());
        label.setPrefWidth (150);
        hBox.getChildren ().add (label);

        TemperatureButton button = new TemperatureButton (sensor);
        button.setText ("Risk");
        button.setFont (new Font ("Arial", 20));
        hBox.getChildren ().add (button);
        HBox.setMargin (button, new Insets (0, 10, 0, 0));

        setOnCloseRequest (new EventHandlerClose (sensor, button, label));

        rootPane.getChildren ().add (hBox);

        Scene scene = new Scene (rootPane);
        setScene (scene);

        show ();
    }
}