package test;

public class Child  extends Dad{
	private int i = 1;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public Child(){}
	public Child(int i ){
		this.i = i;
	}
	void men(){
		System.out.println(i);
	}
	
}
