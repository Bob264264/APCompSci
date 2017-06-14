public class AccountTester{
	public static void main(String[] args){
		AccountAction myCheck = new CheckingAcct("John", 123, 3000);
		AccountAction mySaving = new SavingsAcct("Betty", 456, 4000);
		System.out.println(myCheck.getBalance());
		System.out.println(myCheck.deposit(300));
		System.out.println(myCheck.withdraw(4000));
		System.out.println(myCheck.withdraw(3300));
		System.out.println(myCheck.withdraw(3200));
		System.out.println(mySaving.getBalance());
		System.out.println(mySaving.deposit(400));
		System.out.println(mySaving.withdraw(5000));
		System.out.println(mySaving.withdraw(4400));
		System.out.println(mySaving.withdraw(4300));
		System.out.println(myCheck);
		System.out.println(mySaving);
	}
}