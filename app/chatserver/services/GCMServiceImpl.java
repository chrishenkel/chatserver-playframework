package chatserver.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import play.Logger;
import chatserver.jpa.repositories.AccountRepository;
import chatserver.models.UserAccount;

import com.avaje.ebean.annotation.Transactional;
import com.google.android.gcm.server.Message;

@Service
@Transactional
public class GCMServiceImpl implements GCMService {

	@Autowired
	private SenderService senderService;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	public GCMServiceImpl(SenderService senderService)
	{
		this.senderService = senderService;
	}

	@Override
	public void sendUpdateRequestMessage() {
	}
	
	public List<UserAccount> getAllRegistrants()
	{
		return accountRepo.findAll();
	}

	@Override
	public void sendSyncMessage() {
		List<UserAccount> list = getAllRegistrants();
		List<String> idList = new ArrayList<String>();
		for(UserAccount id : list) 
		{
			idList.add(id.gcmRegId);
		} 
		Message message = new Message.Builder()
		.collapseKey("new-messages")
		 .addData("timestamp", System.currentTimeMillis() + "")
		 .delayWhileIdle(true)
		 .timeToLive(0)
		 .build();
		try {
			senderService.send(message, idList, 4);
		} catch (IOException e) {
			Logger.debug("error sending message via gcm: " + e.getMessage());
		}
	}
}
