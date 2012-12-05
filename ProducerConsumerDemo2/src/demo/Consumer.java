package demo;

import java.util.Random;

public class Consumer implements Runnable {

	private Sp sp;

	public Consumer(Sp sp) {
		this.sp = sp;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			String sanpham = sp.get();
			if(sanpham.equals("HET")) {
				System.out.println("Da thuc hien xong.");      
				break;
			}
			System.out.format("Sanpham nhan duoc: %s%n", sanpham);
			try {
				Thread.sleep(new Random().nextInt(5000));
			} catch (InterruptedException e) {
				System.out.println("Error in Consumer class.");                        
			}
		}
	}
}