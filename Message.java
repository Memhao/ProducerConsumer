
public class Message {
	private final Severity severity;
	private final String content;
	public Message(Severity severity,String content)
	{
		this.severity = severity;
		this.content = content;
	}
	public Severity getSeverity()
	{
		return this.severity;
	}
	public String toString()
	{
		return severity+":"+content;
	}
}
