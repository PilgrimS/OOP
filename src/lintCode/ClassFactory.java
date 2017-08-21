package lintCode;

public class ClassFactory {
	private enum EnumFactory1 {
		singletonFactory;
		private Singleton single;
		private EnumFactory1(){
			single = new Singleton();
		}
		public Singleton getInstance(){
			return single;
		}
	}
	public static Singleton getInstance(){
		return EnumFactory1.singletonFactory.getInstance();
	}
}
