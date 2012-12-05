package demo;

public class Main {
	public static void main(String[] args) {
		Sp mess = new Sp();
		(new Thread(new Producer(mess))).start();
		(new Thread(new Consumer(mess))).start();
	}
}
