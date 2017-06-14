import java.util.Scanner;
import java.util.Arrays;
public class octonumero {
	public static void main(String[] args) {
		System.out.print("Please enter a number: ");
		Scanner in = new Scanner(System.in);
		int dec = in.nextInt();
		String oct = decToOct(dec);
		String sorted = sort(oct);
		for (int i = 0; !oct.equals(sorted) && i < 5; i++){
			oct = decToOct(octToDec(oct) - octToDec(sorted));
			sorted = sort(oct);
		}
		System.out.println(octToDec(oct));
	}
	public static String decToOct(int num){
		return Integer.toString(num, 8);
	}
	public static int octToDec(String s){
		return Integer.parseInt(s, 8);
	}
	public static String sort(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}