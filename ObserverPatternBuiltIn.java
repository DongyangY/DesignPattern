/*
 * Use java built-in Observable and Observer class.
 */

import java.util.*;

class WeatherData extends Observable {
    private float temp, humidity, pressure;

    public void setMeasurements(float temp, float humidity, float pressure) {
	this.temp = temp;
	this.humidity = humidity;
	this.pressure = pressure;
	setChanged();
	notifyObservers();
    }

    public float getTemp() { return temp; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}

class WeatherObserver implements Observer {
    Observable observable;
    private float temp, humidity, pressure;

    public WeatherObserver(Observable o) {
	observable = o;
	observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
	// the observer may observe multiple observables
	if (o instanceof WeatherData) {
	    WeatherData wd = (WeatherData) o;
	    this.temp = wd.getTemp();
	    this.humidity = wd.getHumidity();
	    this.pressure = wd.getPressure();
	    System.out.println("temp: " + temp + " humidity: " + humidity + " pressure: " + pressure);
	}
    }
}

public class ObserverPatternBuiltIn {
    public static void main(String[] args) {
	WeatherData wd = new WeatherData();
	WeatherObserver wo = new WeatherObserver(wd);
	wd.setMeasurements(50.0f, 23.5f, 40.3f);
    }
}
