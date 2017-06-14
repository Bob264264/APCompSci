import java.util.Scanner;
public class WarGame{
	public static void main(String[] args){
		DeckOfCards myDeck = new DeckOfCards();
		myDeck.shuffle();
		Scanner in = new Scanner(System.in);
		Card card1 = null, card2 = null;
		int score1 = 0, score2 = 0;
		int points = 0;
		String again = "y";

		while (myDeck.cardsLeft() > 0 && again.equalsIgnoreCase("y")){
			card1 = myDeck.deal();
			card2 = myDeck.deal();
			System.out.println("Card 1: " + card1);
			System.out.println("Card 2: " + card2);
			if(card1.getFaceVal() > card2.getFaceVal()){
				if(points == 0){
					score1++;
					System.out.println("Player 1 wins 1 point");
				}
				else{
					score1 += points;
					System.out.println("Player 1 wins " + points + " points");
				}
				points = 0;
			}
			else if(card1.getFaceVal() < card2.getFaceVal()){
				if(points == 0){
					score2++;
					System.out.println("Player 2 wins 1 point");
				}
				else{
					score2 += points;
					System.out.println("Player 2 wins " + points + " points");
				}
				points = 0;
			}
			else{		// This means war
				System.out.println("War!");
				points+=4;
			}
			if(myDeck.cardsLeft() > 0 && points == 0){
				System.out.println();
				System.out.println("Player 1: " + score1);
				System.out.println("Player 2: " + score2);
				System.out.print("Play again? ");
				again = in.next().substring(0, 1);
			}
			System.out.println();
		}
		System.out.println("Player 1: " + score1);
		System.out.println("Player 2: " + score2);
		if (score1 > score2)
			System.out.println("Player 1 wins!");
		else if (score1 < score2)
			System.out.println("Player 2 wins!");
		else
			System.out.println("It's a tie!");
	}
}