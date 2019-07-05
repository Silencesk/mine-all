package com.mine.learn.pattern.obsever;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        TemperatureDisplayment temperatureObs = new TemperatureDisplayment();
        PressureDisplayment pressureObs = new PressureDisplayment();
        weatherData.addObserver(temperatureObs);
        weatherData.addObserver(pressureObs);

        System.err.println("---------------");
        weatherData.setMeasurements(26.5f, 36f, 42.2f);
        System.err.println("---------------");
        weatherData.setMeasurements(28.5f, 24f, 36.2f);
    }
}
