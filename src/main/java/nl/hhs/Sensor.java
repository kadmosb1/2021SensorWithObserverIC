package nl.hhs;

public class Sensor {

    public Sensor () {
    }

    private int temperature;

    private void setTemperature (int temperature) {
        this.temperature = temperature;
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
