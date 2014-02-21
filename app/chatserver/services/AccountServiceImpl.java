package chatserver.services;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chatserver.exceptions.UserNotFoundException;
import chatserver.exceptions.UsernameAlreadyExistsException;
import chatserver.jpa.repositories.AccountRepository;
import chatserver.models.UserAccount;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public void register(String username, String password) {
		List<UserAccount> accounts = accountRepo.findByUsername(username);
		if(accounts.size() == 0)
		{
			UserAccount account = new UserAccount();
			account.username = username;
			account.password = password;
			accountRepo.save(account);
		}
		else
		{
			throw new UsernameAlreadyExistsException();
		}
	}

	@Override
	public String refreshToken(String username, String password) {
		List<UserAccount> accounts = accountRepo.findByUsernameAndPassword(username, password);
		if(accounts.size() != 0)
		{
			UserAccount account = accounts.get(0);
			account.sessionToken = UUID.randomUUID().toString();
			account.expires = System.currentTimeMillis() + 3600000;
			accountRepo.save(account);
		}
		else
		{
			throw new UserNotFoundException();
		}
		return accounts.get(0).sessionToken;
	}

	@Override
	public UserAccount findBySessionToken(String sessionToken) {
		List<UserAccount> accounts = accountRepo.findBySessionToken(sessionToken);
		if(accounts.size() != 0)
		{
			return accounts.get(0);
		}
		throw new UserNotFoundException();
	}

	@Override
	public void saveRegId(String username, String password, String regid) {
		List<UserAccount> accounts = accountRepo.findByUsernameAndPassword(username, password);
		if(accounts.size() != 0)
		{
			UserAccount account = accounts.get(0);
			account.gcmRegId = regid;
			accountRepo.save(account);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
}
