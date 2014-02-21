package chatserver.controllers;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import chatserver.services.AccountService;
import chatserver.services.GCMService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@org.springframework.stereotype.Controller
public class Application extends Controller {

}
