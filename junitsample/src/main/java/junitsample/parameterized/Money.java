package junitsample.parameterized;


public class Money {
	 
		private final int amount;
		private final String currency;
		
		public Money(int amount, String currency){
			if (amount < 0){
				throw new IllegalArgumentException("illegal amount");
			}
			this.amount = amount;
			if (currency == null || currency.isEmpty()){
				throw new IllegalArgumentException("Must have a valid currency");
			}
			this.currency = currency;
		}

		public int getAmount() {
			return amount;
		}

		public String getCurrency() {
			return currency;
		}
		
		public boolean equals(Object anObject){
			if (anObject instanceof Money){
				Money money = (Money)anObject;
				return money.getCurrency().equals(currency) && money.getAmount() == amount;
			}
			return false;
		}

}
