package chatserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chatserver.jpa.repositories.ChatMessageRepository;
import chatserver.models.ChatMessage;
import chatserver.models.UserAccount;

@Service
public class ChatServiceImpl implements ChatService {

	private GCMService gcmService;
	
	private AccountService accountService;
	
	private ChatMessageRepository messageRepo;
	
	@Autowired
	public ChatServiceImpl(GCMService gcmService, AccountService accountService,
			ChatMessageRepository messageRepo)
	{
		this.gcmService = gcmService;
		this.accountService = accountService;
		this.messageRepo = messageRepo;
	}

	@Override
	public void sendGlobalMessage(String sessionToken, String message) {
		sendMessageInsideTransaction(sessionToken, message);
		gcmService.sendSyncMessage();
	}

	@Transactional
	private void sendMessageInsideTransaction(String sessionToken, String message) 
	{
		UserAccount account = accountService.findBySessionToken(sessionToken);
		ChatMessage newMessage = new ChatMessage();
		newMessage.message = message;
		newMessage.sender = account.username;
		newMessage.timeStamp = System.currentTimeMillis();
		messageRepo.save(newMessage);
	}

}
