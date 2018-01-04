package junitsample.usingtime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitsample.usingtime.HelloRedesigned;
import junitsample.usingtime.TimeProvider;

@RunWith(JUnitParamsRunner.class)
public class HelloRedesignedTest {

	private HelloRedesigned hello;
	private TimeProvider timeProvider;
	
	private static final Object[] getMorningHours(){
		return new Integer[] { 1, 2,3,4,5,6,7,8,9,10,11}; 
	}
	private static final Object[] getAfternoonHours(){
		return new Integer[] { 12, 13, 14, 15,16,17,18,19,20,21,22,23}; 
	}
	
    @Before
    public void setUp(){
    	timeProvider = mock(TimeProvider.class);
    	hello = new HelloRedesigned(timeProvider);
    }
    
    @Test
    @Parameters(method="getMorningHours")
    public void shouldReturnGoodMorning(int morningHour){
        when(timeProvider.getTime()).thenReturn(getCalendar(morningHour));
		assertEquals("Good Morning", hello.sayHello());
    }
    
	@Test
    @Parameters(method="getAfternoonHours")
	public void shouldDayGoodAfternoon(int afternoonHour){
        when(timeProvider.getTime()).thenReturn(getCalendar(afternoonHour));
		assertEquals("Good Afternoon", hello.sayHello());
	}
	
    private Calendar getCalendar(int hour){
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.HOUR_OF_DAY, hour);
    	return cal;
    }
}
