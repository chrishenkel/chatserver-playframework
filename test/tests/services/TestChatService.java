package tests.services;

import models.ChatMessage;

import org.junit.Before;
import org.junit.Test;

import services.ChatService;
import services.GCMService;
import static org.mockito.Mockito.*;

public class TestChatService {
	
	private GCMService gcmService;
	private ChatService service;
	private ChatMessage message;
	
	@Before
	public void setup()
	{
		gcmService = mock(GCMService.class);
		service = new ChatService(gcmService);
		message = new ChatMessage("body", "sender");
	}
	
	@Test
	public void testReceiveMessage()
	{
		service.receiveMessage(message);
		verify(gcmService).sendUpdateRequestMessage();
	}
}
