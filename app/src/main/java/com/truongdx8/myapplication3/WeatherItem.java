package com.truongdx8.myapplication3;

public class WeatherItem {
    private String DateTime;
    private int WeatherIcon;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public com.truongdx8.myapplication3.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.truongdx8.myapplication3.Temperature temperature) {
        Temperature = temperature;
    }
}
