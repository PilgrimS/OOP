package lintCode;

public class Singleton {
	
	//懒汉模式 单例
	private static Singleton single = null;
	
	//synchronize 粗粒度代码块
	public  static Singleton getInstance(){
		synchronized (Singleton.class) {
			if(single == null) {
	            try {
					Thread.sleep(300);
					single = new Singleton();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
			}
		}
		return single;
	}
	
	//synchronize 细粒度代码块  双重检查
		public  static Singleton getInstance1(){
			if(single == null) {
	            try {
					Thread.sleep(300);
					synchronized (Singleton.class) {
						if(single == null){
							single = new Singleton();
						}
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
			}
			return single;
		}
	
	//synchronize 方法声明
	public synchronized static Singleton getInstance2(){
		if(single == null) {
            try {
				Thread.sleep(300);
				single = new Singleton();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}
		return single;
	}
	
	//静态内部类单例  线程安全
	public static class SingletonHandle{
		private static Singleton single1 = new  Singleton();
	}
	
	public static Singleton getInstance3(){
		return SingletonHandle.single1;
	}
	
	//static 代码块实现
	private static Singleton single2 = null;
	static{
		single2 = new Singleton();
	}
	public static Singleton getInstance4(){
		return single2;
	}
	
	
}
