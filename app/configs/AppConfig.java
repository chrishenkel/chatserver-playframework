package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"chatserver.controllers", "chatserver.services", "chatserver.jpa.repositories"})
@EnableTransactionManagement
public class AppConfig {

}