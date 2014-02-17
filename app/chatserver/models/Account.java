package chatserver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account  {
	public static final String TYPE_DEFAULT = "TYPE_DEFAULT";
	public static final String TYPE_FACEBOOK = "TYPE_FACEBOOK";

	@Id @GeneratedValue
	public Long id;

	public String username;
	public String password;
	public String type;
}
