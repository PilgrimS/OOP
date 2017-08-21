package adapter;

public class HxyAdapter extends Adapter implements Hip {

	public void hip() {
		System.out.println("Run HxyAdapter");
	}
	void walk(){
		System.out.println("Walk HxyAdapter");
	}
	public static void main(String[] args) {
		Hip hip = new HxyAdapter();
		hip.hip();
		//hip.walk();
	}

}
