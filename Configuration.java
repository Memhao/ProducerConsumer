
public class Configuration {
	private String name;
	private int maxNoOfClients;
	private int noOfThreadPerClient;
	private boolean orderMessageBySeveriry;
	private boolean orderMessagesByClientName;
	
	
	
	
	
	
	public boolean isOrderMessagesByClientName() {
		return orderMessagesByClientName;
	}
	public void setOrderMessagesByClientName(boolean orderMessagesByClientName) {
		this.orderMessagesByClientName = orderMessagesByClientName;
	}
	public boolean isOrderMessageBySeveriry() {
		return orderMessageBySeveriry;
	}
	public void setOrderMessageBySeveriry(boolean orderMessageBySeveriry) {
		this.orderMessageBySeveriry = orderMessageBySeveriry;
	}
	public int getNoOfThreadPerClient() {
		return noOfThreadPerClient;
	}
	public void setNoOfThreadPerClient(int noOfThreadPerClient) {
		this.noOfThreadPerClient = noOfThreadPerClient;
	}
	public int getMaxNoOfClients() {
		return maxNoOfClients;
	}
	public void setMaxNoOfClients(int maxNoOfClients) {
		this.maxNoOfClients = maxNoOfClients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
