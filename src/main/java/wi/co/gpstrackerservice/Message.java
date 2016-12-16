package wi.co.gpstrackerservice;

public class Message {

	public String name;

	public String world = "123";

	private Message() {
		// fuck
	}

	public Message(String name, String world) {
		this.name = name;
		this.world = world;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", world=" + world + "]";
	}

}
