package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"controllers", "services", "com.google.android.gcm.server"})
public class AppConfig {

}