package wi.co.gpstrackerservice.domain;

import java.time.LocalDateTime;

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