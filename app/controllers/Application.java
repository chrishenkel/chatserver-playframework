package controllers;

import java.io.IOException;
import java.util.UUID;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.AccountService;
import services.GCMService;
import views.html.index;

import chatserver.models.Account;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private GCMService gcmService;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AccountService accountService;
	
	public GCMService getGcmService() {
		return gcmService;
	}

	public void setGcmService(GCMService gcmService) {
		this.gcmService = gcmService;
	}

	public Result index() throws IOException {
//		GoogleCredential credential = new GoogleCredential()
//				.setAccessToken("blah");
//		Plus plus = new Plus.Builder(new NetHttpTransport(), new GsonFactory(),
//				credential).setApplicationName("Google-PlusSample/1.0").build();
		Account test = new Account();
		test.password = "bblah";
		
		accountService.saveAccount(test);
		
		return ok(index.render("blah" + sessionFactory));//gcmService + " plus = " + plus.activities().search("Google").execute()));
	}

	public Result test() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json data");
		} else {
			String name = json.findPath("name").textValue();
			if (name == null) {
				return badRequest("Missing parameter [name]");
			} else {
				return ok("Hello " + name);
			}
		}
	}

	public Result facebookLogin() {
		JsonNode json = request().body().asJson();
		ObjectNode result = Json.newObject();
		if (json == null) {
			return badRequest("Expecting json data");
		} else {
			String accessKey = json.findPath("accesskey").textValue();
			result.put("token", UUID.randomUUID().toString());
			return ok(result);
		}
	}

	public Result login() {
		JsonNode json = request().body().asJson();
		ObjectNode result = Json.newObject();
		if (json == null) {
			return badRequest("Expecting json data");
		} else {
			String username = json.findPath("username").textValue();
			String password = json.findPath("password").textValue();
			return ok(result);
		}
	}

}
