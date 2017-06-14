public class FunnyFraction {
	private int num;
	private int den;
	
	public FunnyFraction () {
		num = 0;
		den = 1;
	}
	
	public FunnyFraction (int n, int d) {
		this(n, d, 1);
	}

	public FunnyFraction (int n, int d, int x){
		num = n;
		if (d == 0) den = x;
		else den = d;
	}

	public int getNum(){
		return num;
	}

	public int getDen(){
		return den;
	}

	public FunnyFraction funnyAdd (FunnyFraction f) {
		int n = num + den + f.num + f.den;
		int d = (num + f.num) * (den + f.den);
		return (new FunnyFraction(n, d, -1));
	}
	public FunnyFraction funnySubtract (FunnyFraction f){
		int n = f.den - den - f.num - num;
		int d = (f.den - den) * (f.num - num);
		return (new FunnyFraction(n, d, -1));
	}
	public FunnyFraction funnyMult (FunnyFraction f) {
		int n = (int) Math.sqrt(Math.pow((num - f.num),2) + den);
		int d = (int) Math.pow((den - f.den),2) - f.num;
		return (new FunnyFraction(n, d, -1));
	}
	public FunnyFraction funnyDivide (FunnyFraction f) {
		int n = num * f.den;
		int d = f.num * den;
		return (new FunnyFraction(n, d, -1));
	}
	public String toString () {
		return num + "/" + den;
	}

	public static void main(String[] args){
		FunnyFraction f1 = new FunnyFraction (3, 4);
		FunnyFraction f2 = new FunnyFraction (5, 6);
		System.out.println("First numerator: " + f1.getNum());
		System.out.println("First Denominator: " + f1.getDen());
		System.out.println("First fraction: " + f1);
		System.out.println("Second fraction: " + f2);
		System.out.println("Addition: " + f1.funnyAdd(f2));
		System.out.println("Subtraction: " + f1.funnySubtract(f2));
		System.out.println("Multiplication: " + f1.funnyMult(f2));
		System.out.println("Division: " + f1.funnyDivide(f2));
		System.out.println("Default Constructor: " + new FunnyFraction());
	}
}
