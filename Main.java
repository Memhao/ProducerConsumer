import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String arg[])
	{
		BlockingQueue<Message> block0 = new LinkedBlockingQueue<Message>();
		Producer p0 = new Producer(block0, "src/file.txt");
		Consumer c0 = new Consumer(block0);
		BlockingQueue<Message> block1 = new LinkedBlockingQueue<Message>();
		Producer p1 = new Producer(block1, "src/flie.txt");
		Consumer c1 = new Consumer(block1);
		Thread tp0 = new Thread(p0);
		Thread tc0 = new Thread(c0);
		Thread tp1 = new Thread(p1);
		Thread tc1 = new Thread(c1);
		tp0.start();
		tc0.start();
		tp1.start();
		tc1.start();

	}
}
