package concurrent;

public class Caculator implements Runnable {
	private static int count = 0;
	private int number;
	public Caculator(int number) {
		this.number = number;
	}
	
	
	@Override
	public void run() {
		for(int i = 1 ; i <= 10 ; i++){
			System.out.printf("%s: %d * %d = %d-----%d\n",Thread.currentThread().getName(),number,i,i * number,count++);
			
		}
		System.exit(0);
	}

}
