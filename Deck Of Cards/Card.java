public class Card{
	private String suitName, faceName;
	private int suitVal, faceVal;

	public Card(int suit, int value){
		String[] suits = {"Diamond", "Club", "Heart", "Spade"};
		String[] values = {"", "", "Two", "Three", "Four", "Five", "Six", "Seven",
						"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		suitName = suits[suit];
		faceName = values[value];
		suitVal = suit;
		faceVal = value;
	}

	public int getSuitVal(){
		return suitVal;
	}
	public int getFaceVal(){
		return faceVal;
	}

	public String toString(){
		String out = "";
		if (faceVal < 10)
			out += faceVal;
		else
			out += faceName.substring(0,1);
		out += suitName.substring(0,1);
		return out;
	}
}