package chatserver.services;

import org.springframework.beans.factory.annotation.Autowired;

import chatserver.models.ChatMessage;


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
