package concurrent;

public class Caculator1 implements Runnable {
	
	private int number ;
	public Caculator1(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i = 1 ; i <= 10 ; i++){
			System.out.printf("%s: %d * %d == %d\n",Thread.currentThread().getName(),i,number,i * number);
		}
	}

}
