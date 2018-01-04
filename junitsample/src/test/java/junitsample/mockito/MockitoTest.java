package junitsample.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import junitsample.mockito.iCar;

public class MockitoTest {
	
	private iCar myFerrari = mock(iCar.class);
	
	@Test
	public void testifCarisCar(){
		assertTrue(myFerrari instanceof iCar);
	}

	@Test
	public void testDefaultBehavior(){
		assertFalse("should return false as boolean", myFerrari.needsFuel());
		assertEquals("should return 0.0 as double", 0.0, myFerrari.getEngingTemperature(), .1);
	}
	
	@Test
	public void testStubbing(){
		assertFalse("default behavior", myFerrari.needsFuel());
		when(myFerrari.needsFuel()).thenReturn(true);
		assertTrue("after mock should be true", myFerrari.needsFuel());
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldthrowsExeption(){
		when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
		myFerrari.needsFuel();
	}
	
	@Test
	public void testVerification(){
		myFerrari.driveTo("Dallas");
		myFerrari.needsFuel();
		
		verify(myFerrari).driveTo("Dallas");
		verify(myFerrari).needsFuel();
	}
}
