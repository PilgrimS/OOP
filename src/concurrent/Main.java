package concurrent;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Main {

	public static void main(String[] args) {
		
		//Caculator 
		/*for(int i = 1 ; i <= 10 ; i++){
			Caculator ca = new Caculator(i);
			Thread thread = new Thread(ca);
			thread.start();
		}*/
		
		//Caculator1
		Thread threads[] = new Thread[10];
		Thread.State [] status = new Thread.State[10];
		for(int i = 0 ; i < 10 ; i++){
			threads[i] = new Thread(new Caculator1(i));
			if(i%2 == 0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread "+ i);
		}
		try(FileWriter file = new FileWriter("src/log.txt");PrintWriter pw = new PrintWriter(file);) 
		{
			for(int i =0 ; i < 10 ; i++){
				pw.println("Main: Status of Thread " + i +" : "+ threads[i].getState());
				status[i] = threads[i].getState();
			}
			for(int i = 1 ; i < 10 ; i++){
				threads[i].start();
			}
			boolean finish =false;
			while(!finish){
					for(int i = 0 ; i < 10 ; i ++ ){
						if(threads[i].getState() != status[i]){
							writeInfo(pw,threads[i], status[i]);
							status[i] = threads[i].getState();
						}
					}
					finish =true;
					for(int i = 0 ; i < 10 ; i++){
						finish =finish && (threads[i].getState() == State.TERMINATED);
					}
			}
			pw.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		
	}

	private static void writeInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
		pw.printf("Main : Priority: %d\n",thread.getPriority());
		pw.printf("Main : Old State: %s\n",state);
	    pw.printf("Main : New State: %s\n",thread.getState());
		pw.printf("Main : ************************************\n");
	}

}
