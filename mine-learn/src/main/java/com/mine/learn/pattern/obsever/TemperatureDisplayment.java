package com.mine.learn.pattern.obsever;

import java.util.Observable;
import java.util.Observer;

public class TemperatureDisplayment implements Displayment, Observer {
    private float temperature;

    @Override
    public void display() {
        System.out.println("temperature is " + temperature);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.temperature = ((WeatherData)o).getTemperature();
            display();
        }
    }
}
