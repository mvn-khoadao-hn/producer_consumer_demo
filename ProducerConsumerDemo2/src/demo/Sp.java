package demo;

import java.util.ArrayList;

public class Sp {
	// Message sent from producer to consumer.
	private ArrayList<String> lstSanpham = new ArrayList<String>(Constant.max_sp);
	private int count = 0;

	public synchronized String get() {

		if(count == 0)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error in when take message.");                     
			}

		String message = lstSanpham.get(0);
		lstSanpham.remove(0);
		count--;
		System.out.println("So san pham trong kho sau khi lay ra: " + count);

		if(count == Constant.max_sp - 1)
			notifyAll();

		return message;
	}

	public synchronized void put(String sp) {

		if(count == Constant.max_sp)
			try {              
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error in when put message.");                      
			}

		this.lstSanpham.add(sp);
		count++;
		System.out.println("So san pham trong kho sau khi them vao: " + count);

		if(count == 1)
			notifyAll();
	}
}