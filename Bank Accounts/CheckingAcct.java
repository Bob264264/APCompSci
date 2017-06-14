import java.text.NumberFormat;
public class CheckingAcct implements AccountAction{
	private String customer;
	private int accountID;
	private double balance;

	public CheckingAcct(String name, int id, double bal){
		customer = name;
		accountID = id;
		balance = bal;
	}

	public double getBalance(){
		return balance;
	}
	public double deposit(double add){
		balance += add;
		return balance;
	}
	public double withdraw(double add){
		if (balance - (add + 1) >= 0)
			balance -= (add + 1);
		else 
			System.out.println("Insufficient Funds");
		return balance;
	}

	public String toString(){
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String out = "";
		out += ("Name: " + customer + "\n");
		out += ("Account ID: " + accountID + "\n");
		out += ("Balance: " + fmt.format(balance) + "\n");
		return out;
	}
}