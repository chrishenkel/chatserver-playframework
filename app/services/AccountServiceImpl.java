package services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chatserver.models.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private SessionFactory sessionFactory;

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveAccount(Account account) {
		currentSession().save(account);
	}

}
