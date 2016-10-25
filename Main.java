import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String arg[])
	{
		
		


		BlockingQueue<Message> block0 = new LinkedBlockingQueue<Message>();
		Producer p0 = new Producer("1",block0, "src/file.txt");
		Consumer c0 = new Consumer("1","c0",block0);
		BlockingQueue<Message> block1 = new LinkedBlockingQueue<Message>();
		Producer p1 = new Producer("2",block1, "src/flie.txt");
		Consumer c1 = new Consumer("2","c1",block1);
		Thread tp0 = new Thread(p0);
		Thread tc0 = new Thread(c0);
		Thread tp1 = new Thread(p1);
		Thread tc1 = new Thread(c1);
		
//		Configuration config = new Configuration();
//		config.setMaxNoOfClients(2);
//		config.setNoOfThreadPerClient(1);
//		Server s = new Server("", config);
//		s.connect(p1);
//		s.connect(p0);
//		s.startServer();
		tp0.start();
		tc0.start();
		tp1.start();
		tc1.start();


	}
}
