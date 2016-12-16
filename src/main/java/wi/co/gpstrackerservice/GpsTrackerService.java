package wi.co.gpstrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableAutoConfiguration
@SpringBootApplication
@EnableJms
public class GpsTrackerService {

	public static void main(final String[] args) throws Exception {
        SpringApplication.run(GpsTrackerService.class, args);
    }

}
