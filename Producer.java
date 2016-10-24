import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final static Message poisonPill = new Message(Severity.EOF, "");
	private final BlockingQueue<Message> messages;
	private String file;
	private Severity getSeverity(String line)
	{
		Severity s = Severity.NOSEVERITY;
    	if(line.contains("[WARNING]"))
    		s= Severity.WARNING;
    	else if(line.contains("[DEBUG]"))
    		s= Severity.DEBUG;
       	else if(line.contains("[CRITICAL]"))
    		s= Severity.CRITICAL;
       	else if(line.contains("[ERROR]"))
    		s= Severity.ERROR;
    	else if(line.contains("[INFO]"))
    		s= Severity.INFO;
    	else 
    		s= Severity.NOSEVERITY;
    	return s;
	}
	private void getFromFile() throws InterruptedException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	messages.put(new Message(getSeverity(line), line));
		    	System.out.println(line);
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		messages.put(poisonPill);
	}
	
	
	public Producer(BlockingQueue<Message> messages, String file)
	{
		this.messages = messages;
		this.file = file;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			getFromFile();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
