package designpattern.observer;

public interface Subject {
	public void registOb(Ob o);
	public void removeOb(Ob o);
	public void notifyOb();
}
