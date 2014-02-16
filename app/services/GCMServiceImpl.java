package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.android.gcm.server.Sender;

@Service
public class GCMServiceImpl implements GCMService {

	private SenderService senderService;

	@Autowired
	public GCMServiceImpl(SenderService senderService)
	{
		this.senderService = senderService;
	}

	@Override
	public void sendUpdateRequestMessage() {
	}
}
