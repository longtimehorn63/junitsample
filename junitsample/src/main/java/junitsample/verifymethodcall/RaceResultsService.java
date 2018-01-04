package junitsample.verifymethodcall;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {

	private Collection<Client> clients = new HashSet<Client>();
	
	public void addSubsciber(Client client) {
		this.clients.add(client);
	}

	public void send(Message message) {
		clients.forEach((c) -> {
			c.receive(message);	
		});
	}

	public void removeSubsciber(Client client) {
		clients.remove(client);
		
	}

}
