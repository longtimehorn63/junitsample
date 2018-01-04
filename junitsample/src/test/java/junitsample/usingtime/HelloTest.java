package junitsample.usingtime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junitsample.usingtime.Hello;

public class HelloTest {

	@Test
	public void shouldDayGoodMorning(){
		Hello h = new Hello();
		assertEquals("Good Morning", h.sayHello());
	}
	
	@Test
	public void shouldDayGoodAfternoon(){
		Hello h = new Hello();
		assertEquals("Good Afternoon", h.sayHello());
	}
}
