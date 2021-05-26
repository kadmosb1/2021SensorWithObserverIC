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

public class StatusScreen extends Stage {

    public StatusScreen(int x, int y, int temperature) {

        setResizable (false);

        this.setX (x - 250);
        this.setY (y - 31);

        Pane rootPane = new Pane();
        setTitle ("Status");
        rootPane.setMinSize (100, 100);

        HBox hBox = new HBox ();
        hBox.setPrefHeight (100);
        hBox.setAlignment (Pos.CENTER_LEFT);

        TemperatureLabel label = new TemperatureLabel (temperature);
        label.setFont (new Font ("Arial", 45));
        label.setText (temperature);
        label.setPrefWidth (150);
        hBox.getChildren ().add (label);

        TemperatureButton button = new TemperatureButton (temperature);
        button.setText ("Risk");
        button.setFont (new Font ("Arial", 20));
        hBox.getChildren ().add (button);
        HBox.setMargin (button, new Insets (0, 10, 0, 0));

        rootPane.getChildren ().add (hBox);

        Scene scene = new Scene (rootPane);
        setScene (scene);

        show ();
    }
}