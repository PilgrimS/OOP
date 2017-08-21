package concurrent;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
	private boolean	 islocked = false;
	private Thread lockingThread = null;
	private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();
	
	public void lock() throws InterruptedException{
		QueueObject queueObject = new QueueObject();
		boolean isLockedForThisThread = false;
		
		synchronized (this) {
			waitingThreads.add(queueObject);
		}
		while(isLockedForThisThread){
			synchronized (this) {
				isLockedForThisThread = islocked || waitingThreads.get(0) != queueObject;
				if(!isLockedForThisThread){
					islocked = true;
					waitingThreads.remove(queueObject);
					lockingThread = Thread.currentThread();
					return;
				}
			}
			try {
				queueObject.doWait();
			} catch (InterruptedException e) {
				synchronized (this) {
					waitingThreads.remove(queueObject);
				}
				throw e;
			}
		}
	}
	
	public void unlock(){
		if(this.lockingThread != Thread.currentThread()){
			throw new IllegalMonitorStateException("Calling Thread has not locked this lock");
		}
		islocked =false; 
		lockingThread = null;
		if(waitingThreads.size() > 0 ){
			waitingThreads.get(0).doNotify();
		}
	}
}
