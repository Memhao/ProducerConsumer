import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue<Message> messages;
	private String name;
	private PrintWriter out;
	public Consumer(String name, BlockingQueue<Message> messages)
	{
		this.name = name ;
		this.messages = messages;
		try {
			String fileName = "src/out"+this.name+".txt";
			out = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Message m = messages.take();
				if(m.getSeverity() == Severity.EOF)
				{
					out.close();
					break;
				}
			
				System.out.println(m+"[CONSUMER-"+this.name+"]");
				out.write(m.toString()+"\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}
