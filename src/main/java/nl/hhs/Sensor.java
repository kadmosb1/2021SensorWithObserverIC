package nl.hhs;

import java.util.Observable;

public class Sensor extends Observable {

    public Sensor () {
    }

    private int temperature;

    private void setTemperature (int temperature) {
        this.temperature = temperature;
        setChanged ();
        notifyObservers (temperature);
    }

    public void increaseTemperature () {
        setTemperature (++temperature);
    }

    public void decreaseTemperature () {
        setTemperature (--temperature);
    }

    public int getTemperature () {
        return temperature;
    }
}
