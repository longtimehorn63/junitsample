package junitsample.collaborator.arguments;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class PIMTest {
	
	private static final int ONE_HOUR = 60;
	private static final Date START_DATE = new Date();
	private static final int MILLIS_IN_MINUTE = 1000*60;
	private static final Date END_DATE = new Date(START_DATE.getTime() + ONE_HOUR * MILLIS_IN_MINUTE);

	/*
	 * uses Mockito's ArumentCaptor
	 */
	@Test
	public void shouldAddNewEventToCalendar(){
		Calendar calendar = mock(Calendar.class);
		PIM pim = new PIM(calendar);
		
		// ArgumentCaptor will capture the event
		ArgumentCaptor<Meeting> argument = ArgumentCaptor.forClass(Meeting.class);
		
		pim.addMeeting(START_DATE, ONE_HOUR);
		
		// the addEvent is verified and the argument is captured.
		verify(calendar).addEvent(argument.capture());
		
		// retrieving the captured argument
		Meeting meeting = argument.getValue();
		// verifying the argument is as expected
		assertEquals(START_DATE, meeting.getStartDate());
		assertEquals(END_DATE, meeting.getEndDate());
		
	}
}
