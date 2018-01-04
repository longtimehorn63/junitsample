package junitsample.collaborator.arguments;

import java.util.Date;

public class Meeting implements Event {
	
	private final Date startDate;
	private final Date endDate;
	
	public Meeting(Date startDate, Date endDate){
		this.startDate = startDate;
		this.endDate = endDate;
	}
	

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

}
