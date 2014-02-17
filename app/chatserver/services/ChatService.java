package chatserver.services;

import chatserver.models.ChatMessage;

public interface ChatService {

	public void receiveMessage(ChatMessage message);
}
