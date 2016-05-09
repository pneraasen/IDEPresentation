
public class CheckingAccount {
	private String accountHolderName;
	private String accountID;
	private double accountTotal;
	
	public CheckingAccount(String name, String ID)
	{
		accountHolderName = name;
		accountID = ID;
		accountTotal = 0;
	}
	public void setAccountTotal(double num)
	{
			accountTotal += num;
	}
	public void setAccountHolderName(String name)
	{
		accountHolderName = name;
	}
	public void setAccountID(String ID)
	{
		accountID = ID;
	}
	public String getAccountHolderName()
	{
		return accountHolderName;
	}
	public String getAccountID()
	{
		return accountID;
	}
	public double getAccountTotalt()
	{
		return accountTotal;
	}
	

}
