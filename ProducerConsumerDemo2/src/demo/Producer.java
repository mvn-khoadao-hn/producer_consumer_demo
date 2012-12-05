package demo;

import java.util.Random;

public class Producer implements Runnable {

	private Sp sp;

	public Producer(Sp sp) {
		this.sp = sp;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Constant.number_sp; i++) {
			sp.put("San pham "  + i);
			try {
				Thread.sleep(new Random().nextInt(5000));
			} catch (InterruptedException e) {
				System.out.println("Error in Producer class.");                                
			}
		}
		sp.put("HET");
	}
}
