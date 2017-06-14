import java.util.Scanner;

public class daysElapsed {
	
	public static boolean valid = true;
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int [] daysInMonth = {29, 31, 28, 31, 30, 31, 30,
							  31, 31, 30, 31, 30, 31};
		int year, month1, day1, month2, day2;
		do{
			if (!valid) System.out.println("Error in date. Please enter again.");
			System.out.print("Year: ");
			year = input.nextInt();
			System.out.print("Month 1: ");
			month1 = input.nextInt();
			System.out.print("Day 1: ");
			day1 = input.nextInt();
			System.out.print("Month 2: ");
			month2 = input.nextInt();
			System.out.print("Day 2: ");
			day2 = input.nextInt();
		} while (!validate(year, month1, day1, month2, day2, daysInMonth));
		input.close();
		
		System.out.println(nthDay(year, month1, day1, daysInMonth));
		System.out.println(nthDay(year, month2, day2, daysInMonth));
		System.out.println(1 + nthDay(year, month2, day2, daysInMonth) - nthDay(year, month1, day1, daysInMonth));
		
	}
	
	private static int nthDay(int year, int month, int day, int [] days){
		int total = 0;
		for (int i = 1; i < month; i++){
			total += days[i]; 
		}
		total += day;
		if (isLeapYear(year) && month > 2) total += 1;
		return total;
	}
	
	private static boolean validate(int year, int month1, int day1, int month2, int day2, int [] days){
		if (!check(month1, 12)) {valid = false; return false;}
		if (!check(month2, 12)) {valid = false; return false;}
		if (isLeapYear(year) && month1 == 2){
			if (!check(day1, days[0])) {valid = false; return false;}
		} else{
			if (!check(day1, days[month1])) {valid = false; return false;}
		}
		if (isLeapYear(year) && month2 == 2){
			if (!check(day2, days[0])) {valid = false; return false;}
		} else{
			if (!check(day2, days[month2])) {valid = false; return false;}
		}
		if (month1 > month2) {valid = false; return false;}
		if (month1 == month2 && day1 > day2) {valid = false; return false;}
		return true;
	}
	
	private static boolean check (int date, int num){
		return (date > 0 && date <= num);
	}
	
	private static boolean isLeapYear(int y) {
		return ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)));
	} 

}