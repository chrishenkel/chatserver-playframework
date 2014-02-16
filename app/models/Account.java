package models;

import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

public class Account extends Model {
	public static final String TYPE_DEFAULT = "TYPE_DEFAULT";
	public static final String TYPE_FACEBOOK = "TYPE_FACEBOOK";

	@Id
	public Long id;

	@Required
	public String username;
	public String password;

	public String type;
	
	public static Finder<Long, Account> find = new Finder<Long, Account>(Long.class,
			Account.class);
}
