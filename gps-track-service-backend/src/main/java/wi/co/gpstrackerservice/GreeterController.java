package wi.co.gpstrackerservice;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/api/greetings")
public class GreeterController {
 
	private static final String template = "Hello, %s!";

	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Greeting greetNoName() {
		return new Greeting(String.format(template, "World"));
	}

	@RequestMapping(value = "/{name}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Greeting greetName(final @PathVariable String name) {
		return new Greeting(String.format(template, name));
	}

	public class Greeting {
		private final String content;
		private final LocalDateTime time;

		public Greeting(final String content) {
			this.content = content;
			this.time = LocalDateTime.now();
		}

		public String getContent() {
			return this.content;
		}

		public String getTime() {
			return this.time.toString();
		}
	}

}
