package demo;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    @SuppressWarnings("rawtypes")
	private final BlockingQueue sharedQueue;

    @SuppressWarnings("rawtypes")
	public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @SuppressWarnings("unchecked")
	@Override
    public void run() {
        for(int i=0; i<1000; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
