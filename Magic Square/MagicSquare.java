import java.util.Scanner;
public class MagicSquare{
	int[][] square;
	public MagicSquare(int n){
		square = new int[n][n];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++){
			System.out.print("Please enter one row of values, separated by spaces: ");
			for (int j = 0; j < n; j++){
				square[i][j]=input.nextInt();
			}
		}
	}

	public boolean isMagic(){
		for (int[] i:square)
			for (int j:i)
				if (j < 1 || j > Math.pow(square.length, 2))
					return false;
		int target = diag1Sum();
		if (diag2Sum() != target || !checkUnique())
			return false;
		for (int i = 0; i < square.length; i++)
			if (rowSum(i) != target || colSum(i) != target)
				return false;
		return true;
	}

	public boolean isDurer(){
		if (!isMagic())
			return false;
		int target = cornerSum();
		if (centerSum() != target || topBottomCenterColSum() != target || 
			leftRightCenterRowSum() != target || clockwiseSum(0) != target ||
			clockwiseSum(1) != target)
			return false;
		return true;
	}

	private boolean checkUnique(){
		int[] unique = new int[(int)Math.pow(square.length, 2)];
		for (int[] i:square)
			for (int j:i)
				unique[j-1]++;
		for (int i:unique)
			if (i==0) return false;
		return true;
	}

	private int rowSum(int n){
		int sum = 0;
		for (int i:square[n])
			sum += i;
		return sum;
	}
	private int colSum(int n){
		int sum = 0;
		for (int[] i:square)
			sum+=i[n];
		return sum;
	}
	private int diag1Sum(){
		int sum = 0;
		for (int i = 0; i < square.length; i++)
			sum += square[i][i];
		return sum;
	}
	private int diag2Sum(){
		int sum = 0;
		for (int i = 0; i < square.length; i++)
			sum += square[i][square.length - 1 - i];
		return sum;
	}
	
	// Following functions assume 4 by 4 square
	private int cornerSum(){
		return square[0][0] + square[3][0] + square[0][3] + square[3][3];
	}
	private int centerSum(){
		return square[1][1] + square[1][2] + square[2][1] + square[2][2];
	}
	private int topBottomCenterColSum(){
		return square[0][1] + square[0][2] + square[3][1] + square[3][2];
	}
	private int leftRightCenterRowSum(){
		return square[1][0] + square[2][0] + square[1][3] + square[2][3];
	}
	private int clockwiseSum(int n){	// Should only receive values 0 and 1
		return square[0][1+n] + square[1+n][3] + square[3][2-n] + square[2-n][0];
	}

	public String toString(){
		int max = 0;
		for (int[] i:square)
			for (int j:i)
				if (j>max)	
					max = j;
		max = (int)Math.floor(Math.log10(max))+1;
		String out = "";
		for (int i = 0; i < square.length; i++){
			out+="\n";
			for (int j = 0; j < square[i].length; j++){
				for (int k = 0; k < max - ((int)Math.floor(Math.log10(square[i][j])+1)); k++)
					out += " ";
				out+=String.valueOf(square[i][j]) + " ";
			}
		}
		return out;
	}
}