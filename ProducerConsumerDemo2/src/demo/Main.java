package demo;

public class Main {
	public static void main(String[] args) {
		Sp sp = new Sp();
		(new Thread(new Producer(sp))).start();
		(new Thread(new Consumer(sp))).start();
	}
}
