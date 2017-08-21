package concurrent;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {
	//读线程集合
	private Map<Thread,Integer> readingThreads = new HashMap<Thread,Integer>(); 
	//写线程参数
	private int writeAccesses = 0;//
	private int writeRequests = 0;//请求写线程个数
	private Thread writingThread = null;//写线程
	
	public synchronized void lockRead() throws InterruptedException{
		Thread callingThread = Thread.currentThread();
		while(!canGrantReadAccess(callingThread)){
			wait();
		}
		readingThreads.put(callingThread, getReadAccessesCount(callingThread)+1);
	}

	private int getReadAccessesCount(Thread callingThread) {
		Integer accessCount;
		return 0;
	}

	private boolean canGrantReadAccess(Thread callingThread) {
		if(isWriter(callingThread)) return true;
		if(hasWriter()) return false;
		if(isReader(callingThread)) return true;
		if(hasWriterRequests()) return false;
		return true;
	}

	private boolean hasWriterRequests() {
		return readingThreads.size() > 0;
	}

	private boolean isReader(Thread callingThread) {
		return readingThreads.get(callingThread) != null;
	}

	private boolean hasWriter() {
		return writingThread != null;
	}

	private boolean isWriter(Thread callingThread) {
		return writingThread == callingThread;
	}
	
	
	
	
	
}
