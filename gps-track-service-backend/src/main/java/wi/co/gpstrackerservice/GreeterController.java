package wi.co.gpstrackerservice;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wi.co.gpstrackerservice.domain.Greeting;

@RestController
@Controller
@RequestMapping("/api/greetings")
public class GreeterController {

	private static final String template = "Hello, %s!";

	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Greeting greetNoName() {
		return new Greeting(format(template, "World"));
	}

	@RequestMapping(value = "/{name}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Greeting greetName(final @PathVariable String name) {
		return new Greeting(format(template, name));
	}

}
