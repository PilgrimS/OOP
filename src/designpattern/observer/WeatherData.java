package designpattern.observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private ArrayList obs ;
	private float temp;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		obs = new ArrayList();
	}
	
	@Override
	public void registOb(Ob o) {
		obs.add(o);
	}

	@Override
	public void removeOb(Ob o) {
		int i = obs.indexOf(o);
		if(i >= 0){
			obs.remove(i);
		}
	}

	@Override
	public void notifyOb() {
		for(int i = 0; i < obs.size() ; i++){
			Ob ob = (Ob) obs.get(i);
			ob.update(temp, humidity, pressure);
		}
	}
	
	public void measurementsChanged(){
		notifyOb();
	}
	
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temp = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
