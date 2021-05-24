package nl.hhs;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Startscherm extends Application {

    private SensorScreen sensorScreen;

    @Override
    public void start (Stage primaryStage) {

        Sensor sensor = new Sensor ();

        Pane rootPane = new Pane ();
        rootPane.setMinSize (100, 100);
        Scene startScene = new Scene (rootPane);
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
        rootPane.getChildren ().add (hBox);

        primaryStage.setScene (startScene);
        primaryStage.setTitle ("Bowling lanes");
        primaryStage.show ();

        Bounds bounds = rootPane.getBoundsInLocal();
        Bounds screenBounds = rootPane.localToScreen (bounds);

        sensorScreen = new SensorScreen ((int) screenBounds.getMinX (), (int) screenBounds.getMinY (), sensor);
    }
}