package designpattern.observer;

import java.util.Observable;

public class JdkWeatherData extends Observable {
	private float temp;
	private float humidity;
	private float pressure;
	
	public JdkWeatherData() {
	}
	
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temp = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	private void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	
}
