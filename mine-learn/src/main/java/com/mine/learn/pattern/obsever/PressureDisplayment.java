package com.mine.learn.pattern.obsever;

import java.util.Observable;
import java.util.Observer;

public class PressureDisplayment implements Displayment, Observer {
    private float pressure;

    @Override
    public void display() {
        System.out.println("pressure is " + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.pressure = ((WeatherData)o).getPressure();
            display();
        }
    }
}
