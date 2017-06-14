public class DeckOfCards{
	private Card[] deck;
	private int cardsRemain;

	public DeckOfCards(){
		cardsRemain = 52;
		deck = new Card[52];
		for (int i = 0; i < deck.length; i++)
			deck[i] = new Card(i/13, (i%13)+2);
	}

	public void shuffle(){
		for (int i = 0; i < deck.length; i++){
			int j = (int)(Math.random()*52);
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}

	public int cardsLeft(){
		return cardsRemain;
	}

	public Card deal(){
		cardsRemain--;
		if (cardsRemain >= 0)
			return deck[51 - cardsRemain];
		return null;
	}

	public String toString(){
		String out = "";
		for (Card i:deck)
			out += i + "\n";
		return out;
	}
}