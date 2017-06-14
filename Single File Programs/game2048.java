import java.util.Scanner;
public class game2048{
	public static final int SIZE = 4;
	public static final int GOAL = 2048;
	public static void main(String[] arg){
		int[][] board = initialize();
		int[][] temp = new int[board.length][board.length];
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the game!\nUse WASD keys for controls!");
		while (!finished(board)){
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[i].length; j++)
					temp[i][j] = board[i][j];
			while (!boardChanged(board, temp)){
				printBoard(board);
				shiftDir(board, in.nextLine());
			}
			if (!finished(board)) addRandom(board);
		}
		if (reachedGoal(board, GOAL))
			System.out.println("Congratulations!");
		else
			System.out.println("Sorry, you lost.");
		printBoard(board);
	}
	static int[][] initialize(){
		int[][] board = new int[SIZE][SIZE];
		for (int i = 0; i < 2; i++)
			addRandom(board);
		return board;
	}
	static void addRandom(int[][] b){
		if (isFull(b)) return;
		String row = "";
		String col = "";
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[i].length; j++)
				if (b[i][j] == 0){
					row += Integer.toString(i);
					col += Integer.toString(j);
				}
		int index = (int)(Math.random() * row.length());
		b[Character.getNumericValue(row.charAt(index))][Character.getNumericValue(col.charAt(index))] = 2;
	}
	static void shiftDir(int[][] b, String dir){
		int[][] temp = new int[b.length][b.length];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[i].length; j++)
				if (dir.substring(0,1).equalsIgnoreCase("w"))
					temp[j][i] = b[i][j];
				else if (dir.substring(0,1).equalsIgnoreCase("s"))
					temp[j][b.length-i-1] = b[i][j];
				else if (dir.substring(0,1).equalsIgnoreCase("a"))
					temp[i][j] = b[i][j];
				else if (dir.substring(0,1).equalsIgnoreCase("d"))
					temp[i][b.length-j-1] = b[i][j];
		shiftAll(temp);
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[i].length; j++)
				if (dir.substring(0,1).equalsIgnoreCase("w"))
					b[j][i] = temp[i][j];
				else if (dir.substring(0,1).equalsIgnoreCase("s"))
					b[b.length-j-1][i] = temp[i][j];
				else if (dir.substring(0,1).equalsIgnoreCase("a"))
					b[i][j] = temp[i][j];
				else if (dir.substring(0,1).equalsIgnoreCase("d"))
					b[i][b.length-j-1] = temp[i][j];
	}
	static void shiftAll(int[][] rows){
		for (int i = 0; i < rows.length; i++)
			rows[i] = shiftRow(rows[i]);
	}
	static int[] shiftRow(int[] row){
		int[] out = new int[row.length];
		int count = 0;
		for (int i = 0; i < row.length;)
			if (row[i] == 0) i++;
			else{
				int increment = 1;
				while ((i+increment) < row.length && row[i+increment] == 0)
					increment++;
				if ((i+increment) < row.length && row[i] == row[i+increment]){
					out[count] = 2*row[i];
					i++;
				}
				else
					out[count] = row[i];
				i+= increment;
				count++;
			} 
		return out;
	}
	static boolean isFull(int[][] b){
		for (int[] i : b)
			for (int j : i)
				if (j == 0)
					return false;
		return true;
	}
	static boolean noAvailableMoves(int[][] b){
		int[][] temp = new int[b.length][b.length];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[i].length; j++)
				temp[i][j] = b[i][j];
		shiftDir(temp, "w");
		if (boardChanged(b, temp)) return false;
		shiftDir(temp, "s");
		if (boardChanged(b, temp)) return false;
		shiftDir(temp, "a");
		if (boardChanged(b, temp)) return false;
		shiftDir(temp, "d");
		if (boardChanged(b, temp)) return false;
		return true;
	}
	static boolean boardChanged(int[][] curr, int[][] prev){
		for (int i = 0; i < curr.length; i++)
			for (int j = 0; j < curr[i].length; j++)
				if (curr[i][j] != prev[i][j])
					return true;
		return false;
	}
	static boolean finished(int[][] b){
		if (reachedGoal(b, GOAL))
			return true;
		if (!isFull(b) || !noAvailableMoves(b))
			return false;
		return true;
	}
	static boolean reachedGoal(int[][] b, int goal){
		for (int[] i : b)
			for (int j : i)
				if (j >= goal)
					return true;
		return false;
	}
	static void printBoard(int[][] b){
		String out = "";
		for (int[] i : b){
			for (int j : i)
				out += j + "\t";
			out += "\n";
		}
		System.out.println(out);
	}
}