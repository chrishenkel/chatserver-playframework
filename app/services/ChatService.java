package services;

import org.springframework.beans.factory.annotation.Autowired;

import models.ChatMessage;

public class ChatService {

	private GCMService gcmService;

	@Autowired
	public ChatService(GCMService gcmService)
	{
		this.gcmService = gcmService;
	}
	
	public void receiveMessage(ChatMessage message) {
		gcmService.sendUpdateRequestMessage();
	}

}
