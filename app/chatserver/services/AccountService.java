package chatserver.services;

import chatserver.models.UserAccount;


public interface AccountService {
	public void register(String username, String password);

	public String refreshToken(String username, String password);

	public UserAccount findBySessionToken(String sessionToken);

	public void saveRegId(String name, String password, String regid);
}
