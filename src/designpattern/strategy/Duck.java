package designpattern.strategy;

public abstract class Duck {
	FlyBehavior flybehavior;
	QuackBehavior quackbehavior;
	public Duck() {
	}
	
	public void setFlyBehavior(FlyBehavior fb){
		flybehavior = fb;
	}
	public void setQuackBehavior(QuackBehavior qb){
		quackbehavior = qb;
	}
	
	
	public abstract void display();
	
	public void fly(){
		flybehavior.fly();
	}
	
	public void quack(){
		quackbehavior.quack();
	}
	
	public void swim(){
		System.out.println("All duck float");
	}
}
