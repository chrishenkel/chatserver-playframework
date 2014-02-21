package chatserver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserAccount  {

	@Id @GeneratedValue
	public Long id;

	public String username;
	public String password;
	public String sessionToken;
	public long expires;
	public String type;
	public String gcmRegId;

}
