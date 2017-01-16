package wi.co.gpstrackerservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class HelloWorldBean implements CommandLineRunner {

	@Value("${gpsTrackService.testKey}")
	private String configValue;

	@PostConstruct
	public void init() {
		LOG.debug("Hello from " + configValue);
	}

	@Override
	public void run(final String... args) throws Exception {
		LOG.debug("Hello again from " + configValue);
	}

}
