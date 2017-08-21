package test;

public class ObjectTest {
	
	public int a = 1;
	
	public ObjectTest(int i) {
		this.a = i ;
	}
	
	public static void main(String[] args) {
		ObjectTest obj = new ObjectTest(1);
		Object o = obj;
		ObjectTest obj2 = new ObjectTest(1);
		ObjectTest obj3 = obj;
		System.out.println(o == obj);
		System.out.println(o == obj2);
		System.out.println(o == obj3);
		System.out.println(o.getClass());
	}

}
