package chatserver.services;


public interface ChatService {

	public void sendGlobalMessage(String sessionToken, String message);
}
