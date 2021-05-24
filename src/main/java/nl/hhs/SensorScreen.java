package nl.hhs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SensorScreen extends Stage {

    private Sensor sensor;
    private Pane rootPane;
    private Label temperatureLabel;

    void updateTemperatureText () {
        temperatureLabel.setText (" " + sensor.getTemperature () + " *C");
    }

    public SensorScreen (int x, int y, Sensor sensor) {

        setResizable (false);
        initModality (Modality.APPLICATION_MODAL);

        this.sensor = sensor;
        this.setX (x - 250);
        this.setY (y - 31);

        rootPane = new Pane();
        setTitle ("Temperatuursensor");
        rootPane.setMinSize (100, 100);

        HBox hBox = new HBox ();
        hBox.setPrefHeight (100);
        hBox.setAlignment (Pos.CENTER_LEFT);
        temperatureLabel = new Label ();
        temperatureLabel.setFont (new Font ("Arial", 45));
        temperatureLabel.setPrefWidth (150);
        updateTemperatureText ();
        hBox.getChildren ().add (temperatureLabel);

        VBox vBox = new VBox ();
        vBox.setPrefHeight (100);
        vBox.setAlignment (Pos.CENTER_LEFT);

        Insets margins = new Insets (0, 10, 0, 0);

        Button buttonPlus = new Button ("+");
        buttonPlus.setFont (new Font ("Arial", 20));
        buttonPlus.setPrefWidth (50);
        buttonPlus.setAlignment (Pos.CENTER);
        buttonPlus.setStyle ("-fx-base: green;");
        buttonPlus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sensor.increaseTemperature ();
                updateTemperatureText ();
            }
        });
        vBox.getChildren ().add (buttonPlus);
        VBox.setMargin (buttonPlus, margins);

        Button buttonMin = new Button ("-");
        buttonMin.setFont (new Font ("Arial", 20));
        buttonMin.setPrefWidth (50);
        buttonMin.setAlignment (Pos.CENTER);
        buttonMin.setStyle ("-fx-base: red;");
        buttonMin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sensor.decreaseTemperature ();
                updateTemperatureText ();
            }
        });
        vBox.getChildren ().add (buttonMin);
        VBox.setMargin (buttonMin, margins);

        hBox.getChildren ().add (vBox);
        rootPane.getChildren ().add (hBox);

        Scene scene = new Scene (rootPane);
        setScene (scene);

        setOnCloseRequest(new EventHandler<WindowEvent> () {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        show ();
    }
}