import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue<Message> messages;
	private String id;
	private String name;
	private PrintWriter out;
	
	private RotateStrategy rotate;
	public Consumer(String id,String name, BlockingQueue<Message> messages)
	{
		this.id = id;
		this.name = name ;
		this.messages = messages;
		try {
			String fileName = "src/out"+this.name+".txt";
			
			Path path = Paths.get(fileName);
			System.out.println(path.toString());
			if(Files.exists(path))
				out = new PrintWriter(new FileWriter(fileName+"1"));	
			else 
				out = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Consumer(String id,String name, BlockingQueue<Message> messages, RotateStrategy rotate)
	{
		this.id = id;
		this.name = name ;
		this.messages = messages;
		this.rotate = rotate;
	}
	public String getId()
	{
		return this.id;
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true)
//		{
//			try {
//				Message m = messages.take();
//				if(m.getSeverity() == Severity.EOF)
//				{
//					out.close();
//					break;
//				}
//			
//				System.out.println(m+"[CONSUMER-"+this.name+"]");
//				out.write(m.toString()+"\n");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				Thread.currentThread().interrupt();
//				e.printStackTrace();
//			}
//		}
//	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			rotate.execute();
	}
}
