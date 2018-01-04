package junitsample.usingtime;

import java.util.Calendar;

public class HelloRedesigned {
	
	private TimeProvider timeProvider;
	
	public HelloRedesigned(TimeProvider timeProvider){
		this.timeProvider = timeProvider;
	}
	
	public String sayHello(){
		Calendar current = timeProvider.getTime();
		if (current.get(Calendar.HOUR_OF_DAY) < 12){
			return "Good Morning";
		}
		else {
			return "Good Afternoon";
		}
	}

}
