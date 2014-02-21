package chatserver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChatMessage {

	@Id @GeneratedValue
	public Long id;
	public String message;
	public String sender;
	public Long timeStamp;

	public ChatMessage() {
	}
}
