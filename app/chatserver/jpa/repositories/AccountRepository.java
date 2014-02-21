package chatserver.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chatserver.models.UserAccount;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Long>{
	public List<UserAccount> findByUsernameAndPassword(String username, String password);
	public List<UserAccount> findByUsername(String username);
	public List<UserAccount> findBySessionToken(String sessionToken);
}
