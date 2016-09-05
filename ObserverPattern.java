/*
 * The Observer Pattern defines a one-to-many dependency between objects
 * so that when one object changes state, all of its dependents are notified
 * and updated automatically.
 */
import java.util.*;

interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

interface Observer {
    public void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
    public void display();
}

class WeatherData implements Subject {
    private Set<Observer> observers;
    private float temp, humidity, pressure;

    public WeatherData() {
	observers = new HashSet<Observer>();
    }

    public void registerObserver(Observer o) {
	observers.add(o);
    }

    public void removeObserver(Observer o) {
	observers.remove(o);
    }

    public void notifyObservers() {
	for (Observer o : observers) {
	    o.update(temp, humidity, pressure);
	}
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
	this.temp = temp;
	this.humidity = humidity;
	this.pressure = pressure;
	notifyObservers();
    }
}

class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temp, humidity, pressure;
    private Subject weatherData;
    
    public CurrentConditionsDisplay(Subject weatherData) {
	this.weatherData = weatherData;
	weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
	this.temp = temp;
	this.humidity = humidity;
	this.pressure = pressure;
	display();
    }

    public void display() {
	System.out.println("temp: " + temp + " humidity: " + humidity + " pressure: " + pressure);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
	WeatherData weatherData = new WeatherData();
	CurrentConditionsDisplay cur = new CurrentConditionsDisplay(weatherData);
	weatherData.setMeasurements(80.0f, 65.0f, 30.4f);
    }
}
