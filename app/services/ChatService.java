package services;

import models.ChatMessage;

public interface ChatService {

	public void receiveMessage(ChatMessage message);
}
