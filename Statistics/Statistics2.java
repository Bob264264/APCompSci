public class Statistics2{
	int[] rolls;
	int min, max, dice;
	double average, stdDev;
	public Statistics2(int numDice, int numRolls){
		rolls = new int[numRolls];
		dice = numDice;
		rollDice();
		calcStats();
	}

	private void rollDice(){
		for (int i = 0; i < rolls.length; i++){
			for (int j = 0; j < dice; j++)
				rolls[i] += (int)(Math.random()*6)+1;
		}
	}
	private void calcStats(){
		int smallest = 3*dice+1;
		int biggest = -1;
		int sum = 0;
		for (int i:rolls){
			if (i < smallest) smallest = i;
			if (i > biggest) biggest = i;
			sum+=i;
		}
		min = smallest;
		max = biggest;
		average = (double)sum/rolls.length;
		sum = 0;
		for (int i:rolls)
			sum += Math.pow((i-average), 2);
		stdDev = Math.sqrt((double)sum/rolls.length);
	}

	public int getMin(){return min;}
	public int getMax(){return max;}
	public double getAverage(){return average;}
	public double getStdDev(){return stdDev;}

	public void displayHistogram(int key){
		int[] freq = new int[dice*6+1];
		for (int i:rolls)
			freq[i]++;
		System.out.println("Histogram:");
		for(int i = dice; i < freq.length; i++){
			System.out.printf("%2d | %3d | ", i, freq[i]);
			for (int j = 0; j < (freq[i]+key-1)/key; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public void displayData(){
		int count = 1;
		System.out.println("Data:");
		for (int i:rolls){
			if (count % 25 == 1)
				System.out.printf("%2d", i);
			else
				System.out.printf("%3d", i);
			if (count % 25 == 0)
				System.out.println();
			count++;
		}
	}

	public String toString(){
		displayData();
		return "";
	}


	public static void main(String[] args){
		Statistics2 test = new Statistics2(7, 100000);
		System.out.println("Min: " + test.getMin());
		System.out.println("Max: " + test.getMax());
		System.out.println("Average: " + test.getAverage());
		System.out.println("Standard Deviation: " + test.getStdDev());

		test.displayHistogram(150);
		// System.out.println(test);
	}

}