package controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.GCMService;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

	public Result index() {
		return ok(index.render(gcmService + ""));
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
