package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"chatserver.controllers", "chatserver.services", "chatserver.jpa.repositories"})
public class AppConfig {

}