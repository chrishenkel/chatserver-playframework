package chatserver.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import chatserver.exceptions.UserNotFoundException;
import chatserver.exceptions.UsernameAlreadyExistsException;
import chatserver.services.AccountService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@org.springframework.stereotype.Controller
public class AccountController extends Controller {

	@Autowired
	private AccountService accountService;

	public Result register() throws IOException {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json Data");
		} else {
			String name = json.findPath("username").textValue();
			String password = json.findPath("password").textValue();

			try {
				accountService.register(name, password);
			} catch (UsernameAlreadyExistsException exception) {
				ObjectNode result = Json.newObject();
				result.put("message", "A user with that name already exists.");
				return ok(result);
			}

			ObjectNode result = Json.newObject();
			result.put("message", "Account created successfully");
			return created(result);
		}
	}

	public Result login() throws IOException {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json Data");
		} else {
			String name = json.findPath("username").textValue();
			String password = json.findPath("password").textValue();
			String regid = json.findPath("gcmRegId").textValue();
			String token = null;
			
			accountService.saveRegId(name, password, regid);
			
			try {
				token = accountService.refreshToken(name, password);
			} catch (UserNotFoundException exception) {
				ObjectNode result = Json.newObject();
				result.put("message", "A user cannot be found with that username/password.");
				return notFound(result);
			}
			
			ObjectNode result = Json.newObject();
			result.put("message", "Logged in successfully");
			result.put("sessiontoken", token);
			
			return created(result);
		}
		
	}
}
