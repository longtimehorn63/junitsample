package junitsample.collaborator.arguments;

import java.util.Date;

public class PIM {

	private final static int MILLIS_IN_MINUTE = 60*1000;
	
	private Calendar calendar;
	
	public PIM(Calendar calendar){
		this.calendar = calendar;
	}
	
	/*
	 * poor design.  Tries to do too much.  
	 * 
	 * You can't test with something like Mocking and expected meeting and using 
	 * verify like 
	 * 
	 * verify(calendar).addEvent(expectedMeeting);
	 * 
	 * because Meeting doesn't have an equals method defined so it looks at reference 
	 * which fails
	 */
	public void addMeeting(Date startDate, int durationInMinutes){
		Date endDate = new Date(startDate.getTime() + MILLIS_IN_MINUTE*durationInMinutes);
		Meeting meeting = new Meeting(startDate, endDate);
		calendar.addEvent(meeting);
	}
}
