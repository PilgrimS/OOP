package lintCode;

public enum EnumFactory {
	singletonFactory;
	private Singleton single;
	private EnumFactory(){
		single = new Singleton();
	}
	public Singleton getInstance(){
		return single;
	}
}
