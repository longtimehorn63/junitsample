package junitsample.usingtime;

import java.util.Calendar;

public class Hello {

	public String sayHello(){
		Calendar current = Calendar.getInstance();
		if (current.get(Calendar.HOUR_OF_DAY) < 12){
			return "Good Morning";
		}
		else {
			return "Good Afternoon";
		}
		
	}
}
