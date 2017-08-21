package designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class JdkOb implements Observer {
	Observable obs;
	private float temp;
	private float humidity;
	private float pressure;
	
	public JdkOb(Observable obs) {
		this.obs = obs;
		obs.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof JdkWeatherData){
			JdkWeatherData weatherData = (JdkWeatherData)o;
			this.temp = weatherData.getTemp();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
		}
	}

	private void display() {
		System.out.println("Current Weather Data: temp:"+ temp+"   humidity:" +humidity +"   pressure: "+pressure);
	}

}
