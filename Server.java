
import java.util.HashMap;


public class Server {
	private HashMap<String,Producer> clients;
	
	public Server(String name, Configuration config)
	{
		clients = new HashMap<String,Producer>();
	}
	public void startServer()
	{
		if(!clients.isEmpty())
		{
			for(Object c: clients.values())
			{
				Thread cl = new Thread((Producer)c);
				cl.start();	
			}
		}
		else{
			System.out.println("No client connected to server");
		}
	}
	public void connect(Producer client)
	{
		clients.put(client.getId(), client);
	}
	public void disconnect(Producer client)
	{
		clients.remove(client.getId());
	}
}
