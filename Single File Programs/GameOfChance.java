import java.util.Scanner;
public class GameOfChance{
	int points, bet, roll;
	boolean again;

	static Scanner input = new Scanner (System.in);

	public GameOfChance(int n){
		points = n;
		bet = 0;
		roll = 0;
		again = true;
	}

	private void rollDice(){
		roll = ((int)(Math.random()*6) + 1) + ((int)(Math.random()*6) + 1);
		System.out.println("Your roll was: " + roll);
	}

	private void placeBet(){
		displayPoints();
		System.out.print("Please place a bet: ");
		int add = input.nextInt();
		while (add < 1 || add + bet > points){
			if (add < 1)
				System.out.println("You have bet less than 1 point!");
			else 
				System.out.println("You have bet more points than you have!");
			System.out.print("Please place a new bet: ");
			add = input.nextInt();
		}
		bet += add;
		System.out.println("Your bet is now: " + bet + " points");
	}

	private void displayPoints(){
		System.out.println("You have " + points + " points");
	}

	private void playAgain(){
		if (points != 0){
			System.out.print("Do you want to play again (Y/N): ");
			String in = input.next();
			if (in.substring(0,1).equalsIgnoreCase("y")) again = true;
			else again = false;
		}
		else{
			System.out.println("Sorry, you have no money left! Thanks for playing!");
			again = false;
		}
	}

	private void loseGame(){
		System.out.println("You lost.");
		points -= bet;
		bet = 0;
		displayPoints();
	}

	private void winGame(){
		System.out.println("You won!");
		points += bet;
		bet = 0;
		displayPoints();
	}

	public void playGame(){
		while (again){
			if (bet != points) placeBet();
			rollDice();
			if (roll == 2 || roll == 3 || roll == 12) loseGame();
			else if (roll == 7 || roll == 11) winGame();
			else{
				int target = roll;
				while (target > 0){
					System.out.println("You are still in the game!");
					if (bet != points) placeBet();
					else
						System.out.println("You don't have anymore money so you're all in now!");
					rollDice();
					if (roll == target){
						target = 0;
						winGame();
					}
					else if (roll == 7){
						target = 0;
						loseGame();
					}
				}
			}
			System.out.println();
			playAgain();
		}
	}
// }
	public static void main(String[] args){
		GameOfChance myGame = new GameOfChance(50);
		myGame.playGame();
	}
}