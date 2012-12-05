package demo;

import java.util.Random;

public class Producer implements Runnable {

	private Sp mess;

	public Producer(Sp mess) {
		this.mess = mess;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0;	i < new Random().nextInt(50); i++) {
			mess.put("Message " + i);
			try {
				Thread.sleep(new Random().nextInt(5000));
			} catch (InterruptedException e) {
                System.out.println("Error in Producer class.");				
			}
		}
		mess.put("DONE");
	}
}
