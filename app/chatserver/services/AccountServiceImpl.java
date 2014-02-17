package chatserver.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chatserver.jpa.repositories.AccountRepository;
import chatserver.models.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public void register(Account account) {
		
		accountRepo.save(account);
	}
}
