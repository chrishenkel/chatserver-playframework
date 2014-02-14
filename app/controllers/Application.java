package controllers;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.GCMService;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.plus.Plus;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private GCMService gcmService;

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
		return ok(index.render("blah"));//gcmService + " plus = " + plus.activities().search("Google").execute()));
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

	public Result login() {
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
}
