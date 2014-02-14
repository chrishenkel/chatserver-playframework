package services;

import org.springframework.beans.factory.annotation.Autowired;

import models.ChatMessage;

public class ChatServiceImpl implements ChatService {

	private GCMService gcmService;

	@Autowired
	public ChatServiceImpl(GCMService gcmService)
	{
		this.gcmService = gcmService;
	}
	
	@Override
	public void receiveMessage(ChatMessage message) {
		gcmService.sendUpdateRequestMessage();
	}

}
