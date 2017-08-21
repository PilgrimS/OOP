package designpattern.strategy;

public class MyDuck extends Duck {
	public MyDuck() {
		flybehavior = new FlyWithWings();
		quackbehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("Myduck is いくぃばんです");
	}
	
	public static void main(String[] args) {
		Duck duck = new MyDuck();
		duck.fly();
		duck.quack();
		duck.setFlyBehavior(new FlyNoWay());
		duck.fly();
	}

}
