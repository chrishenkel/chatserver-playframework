package chatserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import chatserver.jpa.repositories.ChatMessageRepository;
import chatserver.models.ChatMessage;
import chatserver.services.ChatService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@org.springframework.stereotype.Controller
public class MessageController extends Controller {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatMessageRepository chatRepo;

	public Result sendMessage()
	{
		List<ChatMessage> messages = chatRepo.findAll();
		if(messages.size() > 100)
		{
			removeOldest(messages);
		}
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json Data");
		} else {
			String token = json.findPath("sessiontoken").textValue();
			String message = json.findPath("message").textValue();
			
			chatService.sendGlobalMessage(token, message);

			ObjectNode result = Json.newObject();
			result.put("message", "message sent with token " + token + " and message " + message);
			return ok(result);
		}
	}
	
	private void removeOldest(List<ChatMessage> messages) {
		Long time = Long.MAX_VALUE;
		Long id = -1L;
		for(ChatMessage message : messages)
		{
			if(message.timeStamp < time)
			{
				id = message.id;
				time = message.timeStamp;
			}
		}
		
		if(id != -1)
		{
			chatRepo.delete(id);
		}
	}

	public Result getMessages()
	{
		List<ChatMessage> messages = chatRepo.findAll();
		JsonNode node = Json.toJson(messages);
		return ok(node);
	}
}
