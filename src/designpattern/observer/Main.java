package designpattern.observer;

public class Main {
	public static void main(String[] args) {
		WeatherData weather = new WeatherData();
		CurrentDisplay cd = new CurrentDisplay(weather);
		weather.setMeasurements(0.2f, 0.3f, 0.4f);
		weather.setMeasurements(0.4f, 0.5f, 0.6f);
		weather.setMeasurements(0.3f, 0.4f, 0.5f);
		
		JdkWeatherData wea = new JdkWeatherData();
		JdkOb jo = new JdkOb(wea);
		wea.setMeasurements(0.2f, 0.3f, 0.4f);
		wea.setMeasurements(0.4f, 0.5f, 0.6f);
		wea.setMeasurements(0.3f, 0.4f, 0.5f);
	}
}
