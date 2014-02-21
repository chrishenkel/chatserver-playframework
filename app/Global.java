import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.GlobalSettings;
import configs.AppConfig;
import configs.PersistenceConfig;

public class Global extends GlobalSettings {

	private ApplicationContext ctx;

	@Override
	public void onStart(Application app) {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class,
				PersistenceConfig.class);
	}

	@Override
	public void onStop(Application arg0) {
		super.onStop(arg0);
	}

	@Override
	public <A> A getControllerInstance(Class<A> clazz) {
		return ctx.getBean(clazz);
	}

}