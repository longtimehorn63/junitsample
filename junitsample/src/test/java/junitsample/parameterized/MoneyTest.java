package junitsample.parameterized;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitsample.parameterized.Money;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

	private static final String VALID_CURRENTY = "USD";
	private static final int VALID_AMOUNT = 11;
	
	private static final Object[] getInvalidAmount(){
		return new Integer[] { -4, -12, -22};
	}
	private static final Object[] getInvalidCurrency(){
		return new  Object[] { null, ""};
	}
	
	private static final Object[] getMoney(){
		return new Object[] {
			new Object[] {10,"USD"},
			new Object[] {20,"EUB"} 
		};
	}
	
	@Test
	@Parameters(method="getMoney")
	public void constructorShouldSetAmountAndCurrency(int amount, String currency){
		Money money = new Money(amount, currency);
		
		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getInvalidAmount")
	public void constructorWithInvalidAmount(int invalidAmount ){
		new Money(invalidAmount, VALID_CURRENTY);
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getInvalidCurrency")
	public void constructorWithInvalidCurrency(String invalidCurrency ){
		new Money(VALID_AMOUNT, invalidCurrency);
	}
}
