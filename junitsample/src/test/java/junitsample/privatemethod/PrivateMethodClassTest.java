package junitsample.privatemethod;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import junitsample.privatemethod.PrivateMethodClass;

public class PrivateMethodClassTest {
	
	@Test
	public void testingOptionOne() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		PrivateMethodClass sut = new PrivateMethodClass();
		
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = java.lang.Long.class;
		Method m = sut.getClass().getDeclaredMethod("privateMethod", parameterTypes);
		m.setAccessible(true);
		
		Object[] parameters = new Object[1];
		parameters[0] = 444L;
		
		Boolean result = (Boolean)m.invoke(sut, parameters);
		
		assertTrue(result);
	}
	
	
	// have to have powermock
	@Test
	public void testingOptionTwo() throws Exception{
		
		PrivateMethodClass sut = new PrivateMethodClass();
		
		Boolean result = Whitebox.invokeMethod(sut, "privateMethod", 12345L);
		
		assertTrue(result);
	}
}
