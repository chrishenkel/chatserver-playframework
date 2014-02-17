package tests.services;


import org.junit.Before;
import org.junit.Test;

import chatserver.models.ChatMessage;
import chatserver.services.ChatServiceImpl;
import chatserver.services.GCMService;

import static org.mockito.Mockito.*;

public class TestChatService {
	
	private GCMService gcmService;
	private ChatServiceImpl service;
	private ChatMessage message;
	
	@Before
	public void setup()
	{
		gcmService = mock(GCMService.class);
		service = new ChatServiceImpl(gcmService);
		message = new ChatMessage("body", "sender");
	}
	
	@Test
	public void testReceiveMessage()
	{
		service.receiveMessage(message);
		verify(gcmService).sendUpdateRequestMessage();
	}
}