package nl.hhs;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Startscherm extends Application {

    private Label temperatureLabel;
    private Sensor sensor;
    private int yNextStatusScreen;
    private int xNextStatusScreen;

    private void updateTemperatureText () {
        temperatureLabel.setText (" " + sensor.getTemperature () + " *C");
    }

    @Override
    public void start (Stage primaryStage) {

        sensor = new Sensor ();

        Pane rootPane = new Pane ();
        rootPane.setMinSize (100, 100);
        Scene startScene = new Scene (rootPane);

        VBox vBoxTotaal = new VBox ();

        HBox hBoxControls = new HBox ();
        hBoxControls.setPrefHeight (100);
        hBoxControls.setAlignment (Pos.CENTER_LEFT);
        temperatureLabel = new Label();
        temperatureLabel.setFont (new Font ("Arial", 45));
        temperatureLabel.setPrefWidth (150);
        updateTemperatureText ();
        hBoxControls.getChildren ().add (temperatureLabel);

        VBox vBoxTemperatureButtons = new VBox ();
        vBoxTemperatureButtons.setPrefHeight (100);
        vBoxTemperatureButtons.setAlignment (Pos.CENTER_LEFT);

        Insets margins = new Insets (0, 10, 0, 10);

        Button buttonPlus = new Button ("+");
        buttonPlus.setFont (new Font ("Arial", 20));
        buttonPlus.setPrefWidth (50);
        buttonPlus.setAlignment (Pos.CENTER);
        buttonPlus.setStyle ("-fx-base: green;");
        buttonPlus.setOnAction (actionEvent -> {
            sensor.increaseTemperature ();
            updateTemperatureText ();
        });
        vBoxTemperatureButtons.getChildren ().add (buttonPlus);
        VBox.setMargin (buttonPlus, margins);

        Button buttonMin = new Button ("-");
        buttonMin.setFont (new Font ("Arial", 20));
        buttonMin.setPrefWidth (50);
        buttonMin.setAlignment (Pos.CENTER);
        buttonMin.setStyle ("-fx-base: red;");
        buttonMin.setOnAction (actionEvent -> {
            sensor.decreaseTemperature ();
            updateTemperatureText ();
        });
        vBoxTemperatureButtons.getChildren ().add (buttonMin);
        VBox.setMargin (buttonMin, margins);

        hBoxControls.getChildren ().add (vBoxTemperatureButtons);
        vBoxTotaal.getChildren ().add (hBoxControls);

        Button buttonNewStatus = new Button ("Nieuw statusscherm");
        buttonNewStatus.setFont (new Font ("Arial", 20));
        buttonNewStatus.setPrefWidth (200);
        buttonNewStatus.setAlignment (Pos.CENTER);
        buttonNewStatus.setOnAction (actionEvent -> {
            new StatusScreen(xNextStatusScreen, yNextStatusScreen, sensor);
            xNextStatusScreen -= 250;
        });
        vBoxTotaal.getChildren ().add (buttonNewStatus);
        VBox.setMargin (buttonNewStatus, new Insets (0, 10, 10, 10));

        rootPane.getChildren ().add (vBoxTotaal);

        primaryStage.setScene (startScene);
        primaryStage.setTitle ("Sensor");
        primaryStage.show ();

        Bounds bounds = rootPane.getBoundsInLocal();
        Bounds screenBounds = rootPane.localToScreen (bounds);
        xNextStatusScreen = (int) screenBounds.getMinX ();
        yNextStatusScreen = (int) screenBounds.getMinY ();
    }
}