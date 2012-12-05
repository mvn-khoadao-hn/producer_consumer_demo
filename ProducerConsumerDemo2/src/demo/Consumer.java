package demo;

import java.util.Random;

public class Consumer implements Runnable {

	private Sp mess;

	public Consumer(Sp mess) {
		this.mess = mess;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (String message = mess.take(); ! message.equals("DONE"); message = mess.take()) {
			System.out.format("MESSAGE RECEIVED: %s%n", message);
			try {
				Thread.sleep(new Random().nextInt(5000));
			} catch (InterruptedException e) {
                System.out.println("Error in Consumer class.");			
			}
		}
	}
}
