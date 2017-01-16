package wi.co.gpstrackerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class EnvironmentLogger implements ApplicationListener<ContextRefreshedEvent> {

	@Value("${spring.profiles.active}")
	protected String springProfilesActive;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		LOG.info("=======================================");
		LOG.info("Running with active profiles: {}", springProfilesActive);
		LOG.info("=======================================");
	}

}
