package lintCode;

public class MyThread extends Thread {
	public void run(){
		//System.out.println(Singleton.getInstance4());
		//System.out.println(EnumFactory.singletonFactory.getInstance().hashCode());
		System.out.println(ClassFactory.getInstance().hashCode());
	}
	public static void main(String[] args) {
		MyThread[] my = new MyThread[20];
		for(int i = 0 ; i < 20 ; i++){
			my[i] = new MyThread();
		}
		for(int i = 0 ; i < 20 ; i++){
			my[i].start();
		}
	}
}
