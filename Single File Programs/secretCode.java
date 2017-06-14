import java.util.Scanner;
public class secretCode{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = "";
		while (!validLength(input)){
			System.out.print("Input characters: ");
			input = in.nextLine();
		}
		int sum = 0;
		for (char c : input.toCharArray()) sum += (int)c;
		System.out.println("Sum: " + sum);
		if (getNumDigits(sum) % 2 == 1) sum *= 10;
		if (sum <= 4000) sum *= 4;
		if (getNumDigits(sum) % 2 == 1) sum /= 10;
		System.out.println("Before split: " + sum);
		int[] digits = {sum/100, sum%100};
		System.out.print("Code: ");
		for (int i = 0; i < digits.length; i++)
			if (digits[i] < 65)
				digits[i] += 61;
		for(int i : digits) System.out.print(Character.toString((char)i));
		System.out.println();
	}

	public static boolean validLength(String str){
		return (str.length() >= 2 && str.length() <= 12);
	}
	public static int getNumDigits(int n){
		return (int) Math.floor(Math.log10(n) + 1);
	}
}