import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue<Message> messages;
	public Consumer(BlockingQueue<Message> messages)
	{
		this.messages = messages;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Message m = messages.take();
				if(m.getSeverity() == Severity.EOF)
					break;
				System.out.println(m+"[CONSUMER]");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}
