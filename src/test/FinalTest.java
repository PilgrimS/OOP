package test;

public class FinalTest {
	static final Child c2 = new Child();
	final Child c3 = new Child();
	public static void main(String[] args) {
		final Child c = new Child();
		Child c1 = c;
		//c.setI(4);
		//c.men();
		//c1.setI(6);
		//c1.men();
		//c2 =c1;
		//c2 = new Child(3);
		//c3 = new Child(0);
		//c1.setI(7);
		//c1.men();
	}
}
