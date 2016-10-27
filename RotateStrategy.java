import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

/*
 * if File exists then create a new one
 */
public class RotateStrategy {
	private String serverThreadName;
	private BlockingQueue<Message> messages;
	private PrintWriter out;
	public RotateStrategy(String serverThreadName,BlockingQueue<Message> messages)
	{
		this.serverThreadName = serverThreadName;
		this.messages = messages;
		
		
		try {
			String fileName = "src/out"+this.serverThreadName+".txt";
			
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
	public void execute()
	{
		while(true){
			try {
				Message m = messages.take();
				if(m.getSeverity() == Severity.EOF)
				{
					out.close();
					break;
				}

				System.out.println(m+"[CONSUMER-"+this.serverThreadName+"]");
				out.write(m.toString()+"\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}
