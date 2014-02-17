package chatserver.models;

public class ChatMessage {
	public String message;
	public String sender;

	public ChatMessage(String message, String sender) {
		this.message = message;
		this.sender = sender;
	}
}
