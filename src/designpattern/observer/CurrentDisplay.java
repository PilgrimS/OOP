package designpattern.observer;

public class CurrentDisplay implements Display, Ob {
	
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	
	public CurrentDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registOb(this);
	}
	
	@Override
	public void update(float temp, float homidity, float pressure) {
		this.temp = temp;
		this.humidity = homidity;
		this.pressure  = pressure;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current Weather Data: temp:"+ temp+"   humidity:" +humidity +"   pressure: "+pressure);
	}

}
