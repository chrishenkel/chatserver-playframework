package chatserver.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chatserver.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
