package junitsample.verifymethodcall;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class RaceResultsServiceTest {

	private RaceResultsService raceResults = new RaceResultsService();
	Client clientA = mock(Client.class, "clientA");
	Client clientB = mock(Client.class, "clientB");
	private Message message = mock(Message.class);
	
	@Test
	public void subscrivedClientShouldRecieveMessage(){
		
		raceResults.addSubsciber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}
	@Test
	public void messageShouldBeSentTOallSubscribedClients(){
		
		raceResults.addSubsciber(clientA);
		raceResults.addSubsciber(clientB);
		raceResults.send(message);
		
		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}
	
	@Test
	public void messageShouldBeSentToSubscribersOnly(){
		
		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}
	
	@Test
	public void shouldSendONlyOneMesagetoMultiSubscriber(){

		raceResults.addSubsciber(clientA);
		raceResults.addSubsciber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}
	
	@Test
	public void unsubscribedClientShouldNotRecieveMessages(){

		raceResults.addSubsciber(clientA);
		raceResults.removeSubsciber(clientA);
		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
	}

}
