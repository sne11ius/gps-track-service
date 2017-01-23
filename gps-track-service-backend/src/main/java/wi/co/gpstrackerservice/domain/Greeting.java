package wi.co.gpstrackerservice.domain;

import java.util.Date;

import org.leandreck.endpoints.annotations.TypeScriptType;

@TypeScriptType
public class Greeting {

	private final String content;
	private final Date time;

	public Greeting(final String content) {
		this.content = content;
		this.time = new Date();
	}

	public String getContent() {
		return this.content;
	}

	public String getTime() {
		return this.time.toString();
	}

}
