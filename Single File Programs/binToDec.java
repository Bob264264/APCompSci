import java.util.Scanner;
public class binToDec {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String end = "y";
		while (end.equalsIgnoreCase("y")){
			System.out.println("Binary to Decimal or Decimal to Binary?");
			String input = in.nextLine();
			System.out.println();
			if (input.equalsIgnoreCase("Binary to Decimal")) b2d(in);
			else if (input.equalsIgnoreCase("Decimal to Binary")) d2b(in);
			else System.out.println("Invalid input");
			System.out.println();
			System.out.print("Enter \"y\" to continue or \"n\" to exit: ");
			end = in.nextLine();
		}
	}
	
	private static void b2d(Scanner in){
		System.out.print("Enter Binary number: ");
		char[] digits = in.nextLine().toCharArray();
		int sum = 0;
		for (int i = 0; i < digits.length; i++)
			sum += (digits[i] - 48) * Math.pow(2, digits.length - i - 1);
		System.out.println("BIN " + String.valueOf(digits) + " = DEC " + sum);
	}

	private static void d2b(Scanner in){
		System.out.print("Enter Decimal number: ");
		int num = in.nextInt();
		in.nextLine();			//Skip the new line character after reading int
		int temp = num;
		int highestPow = (int) (Math.log(num)/Math.log(2));
		String output = "";
		for (int i = highestPow; i >= 0; i--){
		 	output += temp/(int)Math.pow(2,i);
		 	temp %= (int)Math.pow(2,i);
		}
		System.out.println("DEC " + num + " = BIN " + output);
	}
}